package com.zemosolabs.mindhive.daggermvvm.download_manager.implementations

import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.util.Log
import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.CallbackKeys.Companion.PUBLISH_PROGRESS
import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.CallbackKeys.Companion.PUBLISH_RESULT
import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.CallbackKeys.Companion.START_DOWNLOAD
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.FileDownloadListener
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.FileExecutorListener
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.Priority
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.PriorityTask
import com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces.IWebServiceProvider
import java.util.concurrent.ThreadPoolExecutor

/**
 * @author atif
 * Created on 25/04/18.
 */

class DownloadRunnable constructor(
        private val webServiceProvider: IWebServiceProvider,
        private val threadPoolExecutor: ThreadPoolExecutor?,
        private val fileExecutorListener: FileExecutorListener,
        private val fileDownloadListener: FileDownloadListener,
        private val downloadTasks : List<DownloadTask>,
        priority: Priority): PriorityTask(priority), Handler.Callback {

    private val TAG = "DownloadRunnable"

    private var pendingDownloads : Int = downloadTasks.size
    private var totalCompletedProgress = 0
    private var failed : Boolean = false

    fun run() {
        for(downloadTask in downloadTasks){
            Log.d(TAG, "Run called in Download Runnable")
            downloadTask.beginDownload(webServiceProvider, this)
            threadPoolExecutor?.execute(downloadTask)
        }
    }

    override fun handleMessage(msg: Message?): Boolean {
        val operation = msg?.what
        return when (operation){
            START_DOWNLOAD -> {
                Log.d(TAG, "Download Started")
                fileDownloadListener.onDownloadStarted(1000)
                true
            }
            PUBLISH_PROGRESS -> {
                totalCompletedProgress += msg.arg1
                Log.d(TAG, "Current Progress is $totalCompletedProgress")
                fileDownloadListener.downloadStatus(totalCompletedProgress, totalCompletedProgress)
                true
            }
            PUBLISH_RESULT -> {
                val downloadTask = msg.obj as DownloadTask
                pendingDownloads--
                if(downloadTask.getDownloadStatus()){
                    Log.d(TAG, "Download of task completed $downloadTask")
                    fileDownloadListener.onDownloadCompleted(downloadTasks)
                }else{
                    Log.e(TAG, "Download of task failed $downloadTask")
                    fileDownloadListener.onDownloadFailed(downloadTasks, "Failed")
                    failed = true
                }
                if(pendingDownloads == 0){
                    if(failed){
                        fileExecutorListener.onDownloadCompleted(this)
                    }else{
                        fileExecutorListener.onDownloadFailed(this, "Failed")
                    }
                }
                true
            }
            else -> {
                false
            }
        }
    }

}
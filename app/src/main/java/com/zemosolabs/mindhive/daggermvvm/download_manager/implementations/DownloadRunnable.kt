package com.zemosolabs.mindhive.daggermvvm.download_manager.implementations

import android.util.Log
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.FileDownloadListener
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.FileExecutorListener
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.Priority
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.PriorityTask
import com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces.IWebServiceProvider

/**
 * @author atif
 * Created on 25/04/18.
 */

class DownloadRunnable constructor(
        private val webServiceProvider: IWebServiceProvider,
        private val fileExecutorListener: FileExecutorListener,
        private val fileDownloadListener: FileDownloadListener,
        private val downloadTasks : List<DownloadTask>,
        priority: Priority): PriorityTask(priority), Runnable {

    private val TAG = "DownloadRunnable"

    override fun run() {
        downloadTasks.forEach({ downloadTask ->
            Log.d(TAG, "Executing the task $downloadTask")
        })
    }

}
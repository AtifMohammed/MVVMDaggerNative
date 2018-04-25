package com.zemosolabs.mindhive.daggermvvm.download_manager.implementations

import android.util.Log
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.DownloadPriority
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.FileDownloadListener
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.FileExecutorListener
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
        private val priority: DownloadPriority): Runnable {

    private val TAG = "DownloadRunnable"

    override fun run() {
        downloadTasks.forEach({ downloadTask ->
            Log.d(TAG, "Executing the task $downloadTask")
        })
    }

}
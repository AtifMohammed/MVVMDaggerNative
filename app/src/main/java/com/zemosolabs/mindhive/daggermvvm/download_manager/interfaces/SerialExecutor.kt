package com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces

import android.support.annotation.IntRange
import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.DownloadTask
import com.zemosolabs.mindhive.daggermvvm.services.interfaces.DownloadServiceCallback

/**
 * @author atif
 * Created on 25/04/18.
 * Serial Executor is similar to Executor with customized implementation
 */
interface SerialExecutor {

    var downloadServiceCallback : DownloadServiceCallback?

    /**
     * Adds the download task to the download singleton and initiates the downloads based on priority
     * @param downloadTask Task to be downloaded.
     * @param fileDownloadListener callback to listen for the download events
     * @param priority priority of the download task
     */
    fun addTask(downloadTask: List<DownloadTask>, fileDownloadListener: FileDownloadListener, priority: Priority, @IntRange(from = 0, to = 1) index : Int)
}
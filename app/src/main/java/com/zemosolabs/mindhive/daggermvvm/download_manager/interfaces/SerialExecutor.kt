package com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces

import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.DownloadTask

/**
 * @author atif
 * Created on 25/04/18.
 */
interface SerialExecutor {
    fun addTask(downloadTask: List<DownloadTask>, fileDownloadListener: FileDownloadListener, priority: DownloadPriority)
}
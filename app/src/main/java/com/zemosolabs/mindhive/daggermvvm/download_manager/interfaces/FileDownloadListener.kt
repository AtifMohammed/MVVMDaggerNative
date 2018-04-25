package com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces

import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.DownloadTask

/**
 * @author atif
 * Created on 25/04/18.
 */
interface FileDownloadListener {
    fun downloadStatus(downloadedSize : Int, totalSize : Int)
    fun onDownloadStarted(totalSize : Int)
    fun onDownloadCompleted(downloadTasks : List<DownloadTask>)
    fun onDownloadFailed(downloadTasks: List<DownloadTask>, errorMessage : String?)
}
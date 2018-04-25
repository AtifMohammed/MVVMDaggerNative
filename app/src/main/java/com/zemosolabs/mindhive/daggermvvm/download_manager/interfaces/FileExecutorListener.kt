package com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces

import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.DownloadRunnable

/**
 * @author atif
 * Created on 25/04/18.
 */

/**
 *
 */
interface FileExecutorListener {
    fun onDownloadCompleted(downloadRunnable: DownloadRunnable)
    fun onDownloadFailed(downloadRunnable: DownloadRunnable, message : String?)
}
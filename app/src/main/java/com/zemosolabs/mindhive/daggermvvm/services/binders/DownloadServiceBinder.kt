package com.zemosolabs.mindhive.daggermvvm.services.binders

import android.os.Binder
import android.support.annotation.IntRange
import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.DownloadTask
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.FileDownloadListener
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.Priority
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.SerialExecutor
import com.zemosolabs.mindhive.daggermvvm.services.interfaces.DownloadServiceCallback

/**
 * @author atif
 * Created on 26/04/18.
 */
class DownloadServiceBinder constructor(private val downloadSerializer: SerialExecutor) : Binder() {

    fun setDownloadServiceCallback(downloadServiceCallback: DownloadServiceCallback){
        downloadSerializer.downloadServiceCallback = downloadServiceCallback
    }

    fun startDownload(tasks: List<DownloadTask>, fieDownloadListener: FileDownloadListener, priority: Priority, @IntRange(from = 0, to = 1) index : Int){
        downloadSerializer.addTask(tasks, fieDownloadListener, priority, index)
    }

}
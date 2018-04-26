package com.zemosolabs.mindhive.daggermvvm.services

import android.os.Binder
import android.support.annotation.IntRange
import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.DownloadTask
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.FileDownloadListener
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.Priority
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.SerialExecutor

/**
 * @author atif
 * Created on 26/04/18.
 */
class DownloadServiceBinder constructor(private val downloadSerializer: SerialExecutor) : Binder() {

    fun startDownload(tasks: List<DownloadTask>, fieDownloadListener: FileDownloadListener, priority: Priority, @IntRange(from = 0, to = 1) index : Int){
        downloadSerializer.addTask(tasks, fieDownloadListener, priority, index)
    }

}
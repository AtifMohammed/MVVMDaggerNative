package com.zemosolabs.mindhive.daggermvvm.view_models

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import com.android.databinding.library.baseAdapters.BR
import com.zemosolabs.mindhive.daggermvvm.R
import com.zemosolabs.mindhive.daggermvvm.beans.DownloadData
import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.DownloadTask
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.FileDownloadListener
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.Priority
import com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces.IResourceProvider
import com.zemosolabs.mindhive.daggermvvm.services.DownloadServiceBinder

/**
 * @author atif
 * Created on 24/04/18.
 */
class FileDownloadFragmentVM constructor(private val resourceProvider: IResourceProvider) : BaseObservable(), FileDownloadListener {

    private val TAG = "FileDownloadFragmentVM"
    var downloadData : DownloadData? = null

    var downloadBinder : DownloadServiceBinder? = null

    @Bindable var maxProgress = 100
        set(value) {
            field = value
            notifyPropertyChanged(BR.maxProgress)
        }

    @Bindable var progress = 25
        set(value) {
            field = value
            notifyPropertyChanged(BR.progress)
        }

    @Bindable var isDownloadInProgress = false
        @Bindable set(value) {
            field = value
            notifyPropertyChanged(BR.downloadInProgress)
        }


    fun getMessage() : String {
        return downloadData!!.getDownloadUrl()
    }

    @Bindable(value = ["isDownloadInProgress"])
    fun getButtonText() : String {
        return if (isDownloadInProgress) resourceProvider.getString(R.string.stop_download) else resourceProvider.getString(R.string.start_download)
    }

    fun startDownload(view : View) {
        val downloadTasks : MutableList<DownloadTask> = ArrayList()
        downloadTasks.add(DownloadTask(""))
        downloadTasks.add(DownloadTask(""))
        downloadTasks.add(DownloadTask(""))
        downloadTasks.add(DownloadTask(""))
        downloadTasks.add(DownloadTask(""))
        downloadTasks.add(DownloadTask(""))
        downloadTasks.add(DownloadTask(""))
        downloadBinder?.startDownload(downloadTasks, this, Priority.HIGHEST, 1)
        this.isDownloadInProgress = this.isDownloadInProgress.not()
    }

    //region File Download Callbacks

    override fun downloadStatus(downloadedSize: Int, totalSize: Int) {
    }

    override fun onDownloadStarted(totalSize: Int) {
    }

    override fun onDownloadCompleted(downloadTasks: List<DownloadTask>) {
    }

    override fun onDownloadFailed(downloadTasks: List<DownloadTask>, errorMessage: String?) {
    }

    //endregion
}
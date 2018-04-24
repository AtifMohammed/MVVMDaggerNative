package com.zemosolabs.mindhive.daggermvvm.view_models

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import com.android.databinding.library.baseAdapters.BR
import com.zemosolabs.mindhive.daggermvvm.R
import com.zemosolabs.mindhive.daggermvvm.beans.DownloadData
import com.zemosolabs.mindhive.daggermvvm.interfaces.IResourceProvider
import com.zemosolabs.mindhive.daggermvvm.interfaces.IWebServiceProvider

/**
 * @author atif
 * Created on 24/04/18.
 */
class FileDownloadFragmentVM constructor(private val webServiceProvider: IWebServiceProvider, private val resourceProvider: IResourceProvider) : BaseObservable() {

    var downloadData : DownloadData? = null

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
        return downloadData!!.getDownloadUrl() + webServiceProvider
    }

    @Bindable(value = ["isDownloadInProgress"])
    fun getButtonText() : String {
        return if (isDownloadInProgress) resourceProvider.getString(R.string.stop_download) else resourceProvider.getString(R.string.start_download)
    }

    fun startDownload(view : View) {
        if(isDownloadInProgress){
            webServiceProvider
        }else{

        }
        this.isDownloadInProgress = this.isDownloadInProgress.not()
    }
}
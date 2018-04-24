package com.zemosolabs.mindhive.daggermvvm.view_models

import com.zemosolabs.mindhive.daggermvvm.beans.DownloadData
import com.zemosolabs.mindhive.daggermvvm.service_providers.WebServiceProvider

/**
 * @author atif
 * Created on 24/04/18.
 */
class FileDownloadFragmentVM constructor(private val webServiceProvider: WebServiceProvider) {

    var downloadData : DownloadData? = null

    fun getMessage() : String {
        return downloadData!!.getDownloadUrl() + webServiceProvider
    }
}
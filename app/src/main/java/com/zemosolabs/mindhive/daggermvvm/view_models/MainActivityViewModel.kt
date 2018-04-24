package com.zemosolabs.mindhive.daggermvvm.view_models

import com.zemosolabs.mindhive.daggermvvm.beans.DownloadData

/**
 * @author atif
 * Created on 23/04/18.
 */
class MainActivityViewModel constructor(private val downloadData : DownloadData, val downloadUrl : String) {

    fun getMessage() : String{
        return downloadData.getMessage() + downloadUrl
    }

}
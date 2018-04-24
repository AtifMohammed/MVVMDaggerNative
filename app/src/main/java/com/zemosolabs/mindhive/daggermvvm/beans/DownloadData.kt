package com.zemosolabs.mindhive.daggermvvm.beans

/**
 * @author atif
 * Created on 24/04/18.
 */

class DownloadData(private val downloadUrl: String, private val storageFile: String) {

    fun getDownloadUrl() : String {
        return downloadUrl
    }
}
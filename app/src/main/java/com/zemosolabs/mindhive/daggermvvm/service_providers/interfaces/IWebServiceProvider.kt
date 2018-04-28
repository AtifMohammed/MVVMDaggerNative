package com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces

/**
 * @author atif
 * Created on 24/04/18.
 */
interface IWebServiceProvider {

    /**
     * @param url url of the file to be downloaded
     * @return Temporary file loction
     */
    fun downloadFile(url : String, fileLocation : String?) : String
}
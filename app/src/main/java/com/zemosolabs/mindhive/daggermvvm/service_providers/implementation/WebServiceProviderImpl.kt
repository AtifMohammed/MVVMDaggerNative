package com.zemosolabs.mindhive.daggermvvm.service_providers.implementation

import android.webkit.URLUtil
import com.zemosolabs.mindhive.daggermvvm.qualifiers.FileQualifier
import com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces.IWebServiceProvider
import okhttp3.OkHttpClient
import java.io.File
import javax.inject.Inject

/**
 * @author atif
 * Created on 24/04/18.
 */
class WebServiceProviderImpl @Inject constructor(private val okHttpClient : OkHttpClient, @FileQualifier("Cache") private val cacheDirectory : File) : IWebServiceProvider {

    override fun downloadFile(url: String, fileLocation : String?): String {
        val tempFileLocation : File = if(fileLocation == null){
            val fileName = URLUtil.guessFileName(url, null, null)
            File(cacheDirectory, fileName)
        }else{
            File(fileLocation)
        }
        if(tempFileLocation.exists()){

        }
        return tempFileLocation.absolutePath
    }

}
package com.zemosolabs.mindhive.daggermvvm.service_providers.implementation

import com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces.IWebServiceProvider
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * @author atif
 * Created on 24/04/18.
 */
class WebServiceProviderImpl @Inject constructor(private val okHttpClient : OkHttpClient) : IWebServiceProvider {

    override fun downloadFile(url: String): String {
        return "Hello"
    }

}
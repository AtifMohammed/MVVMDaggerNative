package com.zemosolabs.mindhive.daggermvvm.service_providers

import com.zemosolabs.mindhive.daggermvvm.interfaces.IWebServiceProvider
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * @author atif
 * Created on 24/04/18.
 */
class WebServiceProvider @Inject constructor(private val okHttpClient : OkHttpClient) : IWebServiceProvider{

}
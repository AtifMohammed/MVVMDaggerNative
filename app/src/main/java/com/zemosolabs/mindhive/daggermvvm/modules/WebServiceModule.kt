package com.zemosolabs.mindhive.daggermvvm.modules

import com.zemosolabs.mindhive.daggermvvm.interfaces.IWebServiceProvider
import com.zemosolabs.mindhive.daggermvvm.service_providers.WebServiceProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * @author atif
 * Created on 24/04/18.
 */

@Module
abstract class WebServiceModule {

    @Binds
    abstract fun provideWebserviceProvider(webServiceProvider: WebServiceProvider) : IWebServiceProvider

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideOKHttpClient() : OkHttpClient {
            return OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.MILLISECONDS)
                    .build()
        }

    }

}
package com.zemosolabs.mindhive.daggermvvm.modules

import android.content.Context
import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.DownloadSerializer
import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.PriorityQueue
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.SerialExecutor
import com.zemosolabs.mindhive.daggermvvm.qualifiers.FileQualifier
import com.zemosolabs.mindhive.daggermvvm.qualifiers.NameQualifier
import com.zemosolabs.mindhive.daggermvvm.scopes.ApplicationScope
import com.zemosolabs.mindhive.daggermvvm.service_providers.implementation.WebServiceProviderImpl
import com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces.IWebServiceProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * @author atif
 * Created on 24/04/18.
 */

@Module
abstract class WebServiceModule {

    @ApplicationScope
    @Binds
    abstract fun bindWebserviceProvider(webServiceProviderImpl: WebServiceProviderImpl) : IWebServiceProvider

    @Module
    companion object {

        @ApplicationScope
        @JvmStatic
        @Provides
        fun provideOKHttpClient() : OkHttpClient {
            return OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.MILLISECONDS)
                    .build()
        }

        @ApplicationScope
        @JvmStatic
        @NameQualifier("Download")
        @Provides
        fun providePriorityQueue() : PriorityQueue {
            return PriorityQueue()
        }

        @ApplicationScope
        @JvmStatic
        @Provides
        fun provideDownloadSerializer(webServiceProvider: IWebServiceProvider, @NameQualifier("Download") priorityQueue: PriorityQueue) : SerialExecutor {
            return DownloadSerializer(webServiceProvider, priorityQueue)
        }

        @ApplicationScope
        @JvmStatic
        @FileQualifier("Cache")
        @Provides
        fun provideCacheDirectory(context : Context) : File {
            return context.cacheDir
        }

    }

}
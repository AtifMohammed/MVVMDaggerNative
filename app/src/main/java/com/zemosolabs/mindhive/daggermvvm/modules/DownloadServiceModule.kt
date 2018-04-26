package com.zemosolabs.mindhive.daggermvvm.modules

import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.SerialExecutor
import com.zemosolabs.mindhive.daggermvvm.scopes.ActivityScope
import com.zemosolabs.mindhive.daggermvvm.services.DownloadServiceBinder
import dagger.Module
import dagger.Provides

/**
 * @author atif
 * Created on 26/04/18.
 */

@Module
abstract class DownloadServiceModule {

    @Module
    companion object {

        @ActivityScope
        @JvmStatic
        @Provides
        fun provideDownloadServiceBinder(downloadSerializer: SerialExecutor) : DownloadServiceBinder {
            return DownloadServiceBinder(downloadSerializer)
        }

    }

}
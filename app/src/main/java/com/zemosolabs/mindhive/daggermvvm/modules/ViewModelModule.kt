package com.zemosolabs.mindhive.daggermvvm.modules

import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.DownloadSerializer
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.SerialExecutor
import com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces.IResourceProvider
import com.zemosolabs.mindhive.daggermvvm.scopes.ActivityScope
import com.zemosolabs.mindhive.daggermvvm.view_models.FileDownloadFragmentVM
import com.zemosolabs.mindhive.daggermvvm.view_models.SplashViewModel
import dagger.Module
import dagger.Provides

/**
 * @author atif
 * Created on 23/04/18.
 */

@Module
abstract class ViewModelModule {

    @Module
    companion object {
        @ActivityScope
        @JvmStatic
        @Provides
        fun provideSplashViewModel() : SplashViewModel{
            return SplashViewModel()
        }

        @ActivityScope
        @JvmStatic
        @Provides
        fun provideFileDownloadVm(downloadSerializer: SerialExecutor, resourceProvider: IResourceProvider) : FileDownloadFragmentVM {
            return FileDownloadFragmentVM(downloadSerializer, resourceProvider)
        }
    }

}

package com.zemosolabs.mindhive.daggermvvm.modules

import com.zemosolabs.mindhive.daggermvvm.beans.DownloadData
import com.zemosolabs.mindhive.daggermvvm.qualifiers.DownloadDataQualifier
import com.zemosolabs.mindhive.daggermvvm.scopes.ActivityScope
import com.zemosolabs.mindhive.daggermvvm.view_models.MainActivityViewModel
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
        fun provideMainViewModel(downloadData: DownloadData, @DownloadDataQualifier("download_url") downloadUrl : String) : MainActivityViewModel {
            return MainActivityViewModel(downloadData, downloadUrl)
        }
    }

}
package com.zemosolabs.mindhive.daggermvvm.modules

import com.zemosolabs.mindhive.daggermvvm.beans.DownloadData
import com.zemosolabs.mindhive.daggermvvm.fragments.FileDownloadFragment
import com.zemosolabs.mindhive.daggermvvm.qualifiers.DownloadDataQualifier
import com.zemosolabs.mindhive.daggermvvm.scopes.ActivityScope
import com.zemosolabs.mindhive.daggermvvm.scopes.FragmentScope
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * @author atif
 * Created on 23/04/18.
 */

@Module(includes = [ViewModelModule::class])
abstract class MainActivityModule {

    @Module(includes = [ViewModelModule::class])
    companion object {

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideDownloadData() : DownloadData {
            return DownloadData("Hello World")
        }

        @JvmStatic
        @ActivityScope
        @Provides
        @DownloadDataQualifier("download_url")
        fun provideDownloadUrl() : String {
            return "Something is better than nothing"
        }

    }

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeDownloadFragmentInjection() : FileDownloadFragment
}
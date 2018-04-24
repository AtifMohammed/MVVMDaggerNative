package com.zemosolabs.mindhive.daggermvvm.modules

import com.zemosolabs.mindhive.daggermvvm.fragments.FileDownloadFragment
import com.zemosolabs.mindhive.daggermvvm.scopes.ActivityScope
import com.zemosolabs.mindhive.daggermvvm.scopes.FragmentScope
import com.zemosolabs.mindhive.daggermvvm.service_providers.WebServiceProvider
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
        fun provideWebserviceProvider() : WebServiceProvider {
            return WebServiceProvider()
        }
    }

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeDownloadFragmentInjection() : FileDownloadFragment
}
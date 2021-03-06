package com.zemosolabs.mindhive.daggermvvm.modules

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.zemosolabs.mindhive.daggermvvm.activities.MainActivity
import com.zemosolabs.mindhive.daggermvvm.activities.SplashActivity
import com.zemosolabs.mindhive.daggermvvm.scopes.ActivityScope
import com.zemosolabs.mindhive.daggermvvm.scopes.ApplicationScope
import com.zemosolabs.mindhive.daggermvvm.service_providers.implementation.ResourceProviderImpl
import com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces.IResourceProvider
import com.zemosolabs.mindhive.daggermvvm.services.DownloadManagerService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * @author atif
 * Created on 23/04/18.
 */

@Module
abstract class ApplicationModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeSplashActivityInjector() : SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivityInjector() : MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [DownloadServiceModule::class])
    abstract fun contributeDownloadServiceInjection() : DownloadManagerService


    @ApplicationScope
    @Binds
    abstract fun bindResourceProvider(resourceProviderImpl: ResourceProviderImpl) : IResourceProvider

    @Module
    companion object {

        @ApplicationScope
        @JvmStatic
        @Provides
        fun provideApplicationContext (application : Application) : Context {
            return application.applicationContext
        }

        @ApplicationScope
        @JvmStatic
        @Provides
        fun provideResourceProvider (context: Context) : Resources {
            return context.resources
        }

    }
}
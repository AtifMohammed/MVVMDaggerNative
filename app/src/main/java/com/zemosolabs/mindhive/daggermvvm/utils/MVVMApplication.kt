package com.zemosolabs.mindhive.daggermvvm.utils

import android.app.Activity
import android.app.Application
import android.app.Service
import com.zemosolabs.mindhive.daggermvvm.components.DaggerMVVMApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

/**
 * @author atif
 * Created on 20/04/18.
 */
class MVVMApplication : Application(), HasActivityInjector, HasServiceInjector {

    @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var dispatchingServiceInjector: DispatchingAndroidInjector<Service>

    override fun onCreate() {
        super.onCreate()
        DaggerMVVMApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    companion object {
        init {
            System.loadLibrary("native-lib.lib")
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    override fun serviceInjector(): AndroidInjector<Service> {
        return dispatchingServiceInjector
    }

}
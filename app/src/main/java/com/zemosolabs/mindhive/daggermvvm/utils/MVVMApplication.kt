package com.zemosolabs.mindhive.daggermvvm.utils

import android.app.Activity
import android.app.Application
import com.zemosolabs.mindhive.daggermvvm.components.DaggerMVVMApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author atif
 * Created on 20/04/18.
 */
class MVVMApplication : Application(), HasActivityInjector {

    @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

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

}
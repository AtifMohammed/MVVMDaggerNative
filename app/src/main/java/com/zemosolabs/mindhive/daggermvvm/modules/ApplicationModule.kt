package com.zemosolabs.mindhive.daggermvvm.modules

import com.zemosolabs.mindhive.daggermvvm.activities.SplashActivity
import com.zemosolabs.mindhive.daggermvvm.scopes.ActivityScope
import dagger.Module
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
}
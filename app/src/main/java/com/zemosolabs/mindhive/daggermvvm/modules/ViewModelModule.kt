package com.zemosolabs.mindhive.daggermvvm.modules

import com.zemosolabs.mindhive.daggermvvm.scopes.ActivityScope
import com.zemosolabs.mindhive.daggermvvm.view_models.SplashViewModel
import dagger.Module
import dagger.Provides

/**
 * @author atif
 * Created on 23/04/18.
 */

@Module
class ViewModelModule {
    @Module
    companion object {
        @ActivityScope
        @JvmStatic
        @Provides
        fun provideSplashViewModel() : SplashViewModel{
            return SplashViewModel()
        }
    }

}
package com.zemosolabs.mindhive.daggermvvm.components

import android.app.Application
import com.zemosolabs.mindhive.daggermvvm.modules.ApplicationModule
import com.zemosolabs.mindhive.daggermvvm.modules.WebServiceModule
import com.zemosolabs.mindhive.daggermvvm.scopes.ApplicationScope
import com.zemosolabs.mindhive.daggermvvm.utils.MVVMApplication
import dagger.BindsInstance
import dagger.Component

/**
 * @author atif
 * Created on 23/04/18.
 */

@ApplicationScope
@Component(
        modules = [ApplicationModule::class, WebServiceModule::class]
)
interface MVVMApplicationComponent{

    fun inject(application: MVVMApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder
        fun build() : MVVMApplicationComponent
    }
}
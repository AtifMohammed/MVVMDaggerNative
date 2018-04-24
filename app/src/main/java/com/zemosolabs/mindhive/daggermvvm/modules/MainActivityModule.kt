package com.zemosolabs.mindhive.daggermvvm.modules

import com.zemosolabs.mindhive.daggermvvm.fragments.FileDownloadFragment
import com.zemosolabs.mindhive.daggermvvm.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author atif
 * Created on 23/04/18.
 */

@Module(includes = [ViewModelModule::class])
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeDownloadFragmentInjection() : FileDownloadFragment
}
package com.zemosolabs.mindhive.daggermvvm.utils

import android.app.Application

/**
 * @author atif
 * Created on 20/04/18.
 */
class MVVMApplication : Application() {

    companion object {
        init {
            System.loadLibrary("native-lib.lib")
        }
    }

}
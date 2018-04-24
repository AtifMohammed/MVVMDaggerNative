package com.zemosolabs.mindhive.daggermvvm.interfaces

import android.support.annotation.StringRes

/**
 * @author atif
 * Created on 24/04/18.
 */
interface IResourceProvider {
    fun getString(@StringRes resId : Int) : String
    fun getString(@StringRes resId: Int, vararg args : Any) : String
}
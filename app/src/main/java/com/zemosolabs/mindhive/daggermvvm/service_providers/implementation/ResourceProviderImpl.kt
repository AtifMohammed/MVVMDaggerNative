package com.zemosolabs.mindhive.daggermvvm.service_providers.implementation

import android.content.res.Resources
import com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces.IResourceProvider
import javax.inject.Inject

/**
 * @author atif
 * Created on 24/04/18.
 */
class ResourceProviderImpl @Inject constructor(private val resources: Resources): IResourceProvider {

    override fun getString(resId: Int): String {
        return resources.getString(resId)
    }

    override fun getString(resId: Int, vararg args: Any) : String {
        return resources.getString(resId, args)
    }
}
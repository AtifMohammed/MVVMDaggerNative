package com.zemosolabs.mindhive.daggermvvm.qualifiers

import javax.inject.Qualifier

/**
 * @author atif
 * Created on 24/04/18.
 */

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class DownloadDataQualifier(val value: String = "")
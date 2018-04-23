package com.zemosolabs.mindhive.daggermvvm.scopes

import dagger.releasablereferences.CanReleaseReferences
import javax.inject.Scope


/**
 * @author atif
 * Created on 23/04/18.
 */

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@CanReleaseReferences
@Scope
annotation class SingleObectScope
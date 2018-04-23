package com.zemosolabs.mindhive.daggermvvm.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zemosolabs.mindhive.daggermvvm.R
import com.zemosolabs.mindhive.daggermvvm.databinding.ActivitySplashBinding
import com.zemosolabs.mindhive.daggermvvm.navigators.SplashNavigator
import com.zemosolabs.mindhive.daggermvvm.view_models.SplashViewModel

class SplashActivity : AppCompatActivity(), SplashNavigator{

    var splashViewModel : SplashViewModel = SplashViewModel()

    //region Activity Methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activitySplashBinding : ActivitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        activitySplashBinding.splash = splashViewModel
    }

    override fun onResume() {
        super.onResume()
        openMainActivity()
    }

    //endregion

    //region Navigator

    override fun closeApplication() {

    }

    override fun openMainActivity() {

    }

    //endregion
}

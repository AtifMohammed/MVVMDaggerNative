package com.zemosolabs.mindhive.daggermvvm.activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.zemosolabs.mindhive.daggermvvm.R
import com.zemosolabs.mindhive.daggermvvm.databinding.ActivitySplashBinding
import com.zemosolabs.mindhive.daggermvvm.navigators.SplashNavigator
import com.zemosolabs.mindhive.daggermvvm.view_models.SplashViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), SplashNavigator{

    private val TAG = "SplashActivity"

    @Inject
    lateinit var splashViewModel : SplashViewModel

    //region Activity Methods

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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
        Log.d(TAG, "Activity Closed")
    }

    override fun openMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    //endregion
}

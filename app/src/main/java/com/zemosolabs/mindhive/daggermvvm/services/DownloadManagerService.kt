package com.zemosolabs.mindhive.daggermvvm.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dagger.android.AndroidInjection
import javax.inject.Inject

class DownloadManagerService : Service() {

    @Inject lateinit var downloadServiceBinder : DownloadServiceBinder

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder {
        return downloadServiceBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

}

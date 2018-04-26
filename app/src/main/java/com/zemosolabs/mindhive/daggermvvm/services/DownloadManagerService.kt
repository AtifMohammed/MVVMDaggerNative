package com.zemosolabs.mindhive.daggermvvm.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.zemosolabs.mindhive.daggermvvm.services.binders.DownloadServiceBinder
import com.zemosolabs.mindhive.daggermvvm.services.interfaces.DownloadServiceCallback
import dagger.android.AndroidInjection
import javax.inject.Inject

class DownloadManagerService : Service(), DownloadServiceCallback {

    @Inject lateinit var downloadServiceBinder : DownloadServiceBinder

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder {
        downloadServiceBinder.setDownloadServiceCallback(this)
        return downloadServiceBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onDownloadsCompleted() {
        stopSelf()
    }

}

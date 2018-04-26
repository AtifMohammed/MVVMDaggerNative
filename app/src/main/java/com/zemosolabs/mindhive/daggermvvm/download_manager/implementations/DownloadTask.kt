package com.zemosolabs.mindhive.daggermvvm.download_manager.implementations

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.CallbackKeys.Companion.PUBLISH_RESULT
import com.zemosolabs.mindhive.daggermvvm.service_providers.interfaces.IWebServiceProvider

/**
 * @author atif
 * Created on 25/04/18.
 */
class DownloadTask : Runnable {

    private var webServiceProvider : IWebServiceProvider? = null
    private var mainLoopHandler : Handler? = null
    private var status : Boolean = false
    private val TAG = "DownloadTask"
    val fileName : String = "SomeName"

    fun beginDownload(webServiceProvider: IWebServiceProvider, callback : Handler.Callback) {
        this.webServiceProvider = webServiceProvider
        this.mainLoopHandler = Handler(Looper.getMainLooper(), callback)
    }

    fun getDownloadStatus() : Boolean {
        return status
    }

    override fun run() {
        Log.d(TAG, "Execution of task started in thread ${Thread.currentThread()} $webServiceProvider")
        mainLoopHandler?.obtainMessage(PUBLISH_RESULT, this)?.sendToTarget()
    }

}
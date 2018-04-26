package com.zemosolabs.mindhive.daggermvvm.fragments


import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.IBinder
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.zemosolabs.mindhive.daggermvvm.R
import com.zemosolabs.mindhive.daggermvvm.beans.DownloadData
import com.zemosolabs.mindhive.daggermvvm.databinding.FragmentFileDownloadBinding
import com.zemosolabs.mindhive.daggermvvm.service_providers.implementation.ResourceProviderImpl
import com.zemosolabs.mindhive.daggermvvm.services.DownloadManagerService
import com.zemosolabs.mindhive.daggermvvm.services.DownloadServiceBinder
import com.zemosolabs.mindhive.daggermvvm.view_models.FileDownloadFragmentVM
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FileDownloadFragment : Fragment() {

    private val TAG = "FileDownloadFragment"

    @Inject lateinit var downloadViewModel : FileDownloadFragmentVM
    @Inject lateinit var resourceProviderImpl : ResourceProviderImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binder : FragmentFileDownloadBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_file_download, container, false)
        binder.downloadVm = downloadViewModel
        downloadViewModel.downloadData = DownloadData(resourceProviderImpl.getString(R.string.hello), resourceProviderImpl.getString(R.string.world))
        return binder.root
    }

    override fun onResume() {
        super.onResume()
        context?.bindService(Intent(context?.applicationContext, DownloadManagerService::class.java), serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        context?.unbindService(serviceConnection)
        super.onDestroy()
    }

    private val serviceConnection : ServiceConnection = object : ServiceConnection{

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG, "Service Disconnected")
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d(TAG, "Service Connected")
            downloadViewModel.downloadBinder = service as DownloadServiceBinder
        }

    }

    companion object {
        fun getInstance() : FileDownloadFragment {
            return FileDownloadFragment()
        }
    }
}

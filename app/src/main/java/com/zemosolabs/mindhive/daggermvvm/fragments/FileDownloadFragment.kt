package com.zemosolabs.mindhive.daggermvvm.fragments


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.zemosolabs.mindhive.daggermvvm.R
import com.zemosolabs.mindhive.daggermvvm.beans.DownloadData
import com.zemosolabs.mindhive.daggermvvm.databinding.FragmentFileDownloadBinding
import com.zemosolabs.mindhive.daggermvvm.service_providers.ResourceProvider
import com.zemosolabs.mindhive.daggermvvm.view_models.FileDownloadFragmentVM
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FileDownloadFragment : Fragment() {

    @Inject lateinit var downloadViewModel : FileDownloadFragmentVM
    @Inject lateinit var resourceProvider: ResourceProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binder : FragmentFileDownloadBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_file_download, container, false)
        binder.downloadVm = downloadViewModel
        downloadViewModel.downloadData = DownloadData(resourceProvider.getString(R.string.hello), resourceProvider.getString(R.string.world))
        return binder.root
    }

    companion object {
        fun getInstance() : FileDownloadFragment {
            return FileDownloadFragment()
        }
    }
}

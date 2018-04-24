package com.zemosolabs.mindhive.daggermvvm.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.zemosolabs.mindhive.daggermvvm.R
import dagger.android.support.AndroidSupportInjection

/**
 * A simple [Fragment] subclass.
 *
 */
class FileDownloadFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_file_download, container, false)
    }

    companion object {
        fun getInstance() : FileDownloadFragment {
            return FileDownloadFragment()
        }
    }
}

package com.caesar.cskoin.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caesar.cskoin.CSKoinLog

import com.caesar.cskoin.R

/**
 * A simple [Fragment] subclass.
 */
class MyFragment(val str: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        CSKoinLog.I("在碎片中的参数:"+str)
        return inflater.inflate(R.layout.fragment_my, container, false)
    }
}

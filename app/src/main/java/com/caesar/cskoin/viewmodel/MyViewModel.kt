package com.caesar.cskoin.viewmodel

import androidx.lifecycle.ViewModel
import com.caesar.cskoin.CSKoinLog

/**
 * Created by Caesar
 * email : caesarshao@163.com
 */
class MyViewModel:ViewModel() {
    var NumData :Int = 0
    override fun onCleared() {
        super.onCleared()
        CSKoinLog.I("调用了销毁方法")
    }
}
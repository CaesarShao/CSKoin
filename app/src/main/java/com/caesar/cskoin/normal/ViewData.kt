package com.caesar.cskoin.normal

import android.view.View
import com.caesar.cskoin.CSKoinLog

/**
 * Created by Caesar
 * email : caesarshao@163.com
 */
class ViewData(val view: View) {
    fun prinId() {
        CSKoinLog.I("获取ViewData的按钮id" + view.id.toString())
    }
}
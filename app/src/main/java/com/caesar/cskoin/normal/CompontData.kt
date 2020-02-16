package com.caesar.cskoin.normal

import com.caesar.cskoin.CSKoinLog
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject

/**
 * Created by Caesar
 * email : caesarshao@163.com
 */
class CompontData : KoinComponent {
    val appD1 by inject<AppData>()//懒加载模式
    val appD2 = get<AppData>()//非懒加载模式
    fun priInfo() {
        CSKoinLog.I("CompontData中appD1地址:" + appD1.hashCode() + "////appD2地址:" + appD2.hashCode())
    }
}
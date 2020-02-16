package com.caesar.cskoin.normal

import android.app.Application
import com.caesar.cskoin.CSKoinLog

/**
 * Created by Caesar
 * email : caesarshao@163.com
 */
class NormalData {
    var numData: Int = 0
    var userName: String = ""
    var mApp: Application? = null
    var appData: AppData? = null
    constructor(userName: String, numData: Int) {//构造方法1
        this.userName = userName
        this.numData = numData
    }
    constructor(appData: AppData) {//构造方法2
        this.appData = appData
    }
    constructor(mApp: Application) {//构造方法3
        this.mApp = mApp
    }
    fun printInfo(str: String) {//打印里面的信息
        CSKoinLog.I(str + "的信息    numData:" + numData + "///userName:" + userName + "///application是否为空:" + (mApp == null) + "///appData是否为空:" + (appData == null))
    }
}
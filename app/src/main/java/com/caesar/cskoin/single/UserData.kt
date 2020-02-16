package com.caesar.cskoin.single

import com.caesar.cskoin.CSKoinLog

/**
 * Created by Caesar
 * email : caesarshao@163.com
 */
class UserData {
    var userName: String? = null
    var age: Int? = null
    fun info() {
        CSKoinLog.I("用户名:" + userName + "////年龄:" + age)
    }
}
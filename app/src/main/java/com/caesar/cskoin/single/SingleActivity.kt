package com.caesar.cskoin.single

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.caesar.cskoin.CSKoinLog
import com.caesar.cskoin.R
import org.koin.android.ext.android.inject

class SingleActivity : AppCompatActivity() {
    val userData: UserData by inject()
    val userData2: UserData by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        CSKoinLog.I(userData.hashCode().toString())
        CSKoinLog.I(userData2.hashCode().toString())
        userData.userName = "张飞"
        userData.age = 17
        userData2.info()
        userData2.userName = "关羽"
        userData2.age = 18
        userData.info()
    }
}

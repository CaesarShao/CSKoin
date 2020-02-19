package com.caesar.cskoin.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.caesar.cskoin.CSKoinLog
import com.caesar.cskoin.R
import org.koin.android.ext.android.inject

class OtherActivity : AppCompatActivity() {
    val proData :ProData by inject()
    val timeData :TimeData by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        CSKoinLog.I("通过Property方式获取:"+proData.string)
        CSKoinLog.I("timeData里面的属性:"+timeData.ProD.string)
    }
}

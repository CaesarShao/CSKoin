package com.caesar.cskoin.normal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caesar.cskoin.CSKoinLog
import com.caesar.cskoin.R
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class NormalActivity : AppCompatActivity() {
    val appData by inject<AppData>()
////

    val norData1 by inject<NormalData>(named("nameAnum"))//限定符方1
    val norData2: NormalData by inject(named("app"))//限定符方2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
        CSKoinLog.I("application是否为空:" + (appData.mApp == null))
        ////////////

        val norData3 = get<NormalData>(named("appData"))//限定符3
        norData1.printInfo("norData1")
        norData2.printInfo("norData2")
        norData3.printInfo("norData3")
    }
}

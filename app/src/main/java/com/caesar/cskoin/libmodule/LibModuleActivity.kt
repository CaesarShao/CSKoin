package com.caesar.cskoin.libmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.caesar.cskoin.CSKoinLog
import com.caesar.cskoin.R
import com.caesarlib.koin.LibData
import org.koin.android.ext.android.inject

class LibModuleActivity : AppCompatActivity() {

    val libData by inject<LibData>()
    val moduleData by inject<ModuleData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lib_module)
        CSKoinLog.I("直接依赖的libData:" + libData.hashCode().toString())
        CSKoinLog.I("moduleData中的libData:" + moduleData.libData.hashCode().toString())
    }
}

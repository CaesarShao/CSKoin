package com.caesar.cskoin.normal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.caesar.cskoin.CSKoinLog
import com.caesar.cskoin.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class NormalTwoActivity : AppCompatActivity() {
    val weatherData by inject<WeatherData>(named("wea_name"))
    val weatherData2 by inject<WeatherData>(named("wea_app"))
    val weatherData3 by inject<WeatherData>(named("wea_appData"))
    var btnShow: Button? = null
    val viewData by inject<ViewData> { parametersOf(btnShow) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_two)
        weatherData.printData("weather1")
        weatherData2.printData("weather2")
        weatherData3.printData("weather3")
        btnShow = findViewById(R.id.btn_show)//这边要注意,btn的初始化要在ViewData的调用之前,否则会报空指针.koin的注入是懒加载模式的,只有在调用对象的时候,才会实例化对象
        viewData.prinId()
        CSKoinLog.I("这个是直接获取按钮id" + btnShow?.id.toString())

        CompontData().priInfo()//这边直接new对象,看里面注入的对象信息
    }
}

package com.caesar.cskoin.factory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.caesar.cskoin.CSKoinLog
import com.caesar.cskoin.R
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class FactoryActivity : AppCompatActivity() {
    //调用方式有大致下面几种,后面会再说到
    val person: Person by inject()//方法一
    val person2 by inject<Person>()//方法二
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factory)
        val person3 = get<Person>()//方法三
        person.speak()
        person2.speak()
        person3.speak()
        CSKoinLog.I(person.hashCode().toString())
        CSKoinLog.I(person2.hashCode().toString())
        CSKoinLog.I(person3.hashCode().toString())
    }
}

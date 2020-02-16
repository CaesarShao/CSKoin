package com.caesar.cskoin.fragment

//import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caesar.cskoin.R
import org.koin.androidx.scope.currentScope

class FragActivity : AppCompatActivity() {
    val myFrag: MyFragment by currentScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
//        setupKoinFragmentFactory()//要在调用父类的方法之前调用
//        setupKoinFragmentFactory(currentScope)//碎片跟作用域的用法
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.mvvm_frame, MyFragment::class.java, null, null)
//            .commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.mvvm_frame,myFrag)
            .commit()
    }
}

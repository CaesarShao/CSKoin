package com.caesar.cskoin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.caesar.cskoin.factory.FactoryActivity
import com.caesar.cskoin.fragment.FragActivity
import com.caesar.cskoin.libmodule.LibModuleActivity
import com.caesar.cskoin.normal.NormalActivity
import com.caesar.cskoin.normal.NormalTwoActivity
import com.caesar.cskoin.other.OtherActivity
import com.caesar.cskoin.scope.ScopeCurentActivity
import com.caesar.cskoin.scope.ScopeData
import com.caesar.cskoin.scope.ScopeTypeTwo
import com.caesar.cskoin.single.SingleActivity
import com.caesar.cskoin.viewmodel.ViewModelActivity
import org.koin.android.ext.android.getKoin
import org.koin.androidx.scope.currentScope
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    fun initView() {
        findViewById<Button>(R.id.btn_factory).setOnClickListener {
            goActivity(FactoryActivity::class.java)
        }
        findViewById<Button>(R.id.btn_single).setOnClickListener {
            goActivity(SingleActivity::class.java)
        }
        findViewById<Button>(R.id.btn_viewmodel).setOnClickListener {
            goActivity(ViewModelActivity::class.java)
        }
        findViewById<Button>(R.id.btn_normal).setOnClickListener {
            goActivity(NormalActivity::class.java)
        }
        findViewById<Button>(R.id.btn_normal2).setOnClickListener {
            goActivity(NormalTwoActivity::class.java)
        }
        findViewById<Button>(R.id.btn_lib).setOnClickListener {
            goActivity(LibModuleActivity::class.java)
        }
        findViewById<Button>(R.id.btn_scope).setOnClickListener {
            doScope()
            goActivity(ScopeCurentActivity::class.java)
        }
        findViewById<Button>(R.id.btn_frag).setOnClickListener {
            goActivity(FragActivity::class.java)
        }
        findViewById<Button>(R.id.btn_other).setOnClickListener {
            goActivity(OtherActivity::class.java)
        }
    }


    fun goActivity(clz: Class<*>) {
        val intent = Intent(this, clz)
        startActivity(intent)
    }

    fun doScope() {
        val scopeData = getKoin().getScopeOrNull("scopeId1")//注意这边获取一个可空的方法,直接getScope获取到的可能为空,会报空指针
        CSKoinLog.I("MainActivity中获取scope是否为空" + (scopeData == null))
        val typeScope = getKoin().getScopeOrNull(CSKoinLog.scopeId)
        CSKoinLog.I("MainActivity获取的ScopeTypeTwo是否为空:" + (typeScope == null))
        Thread {
            Thread.sleep(2000)
            val scopeData2 = getKoin().getScopeOrNull("scopeId1")
            val data = scopeData2?.get<ScopeData>()
            CSKoinLog.I("MainActivity中延迟2秒获取的scope是否为空" + (scopeData2 == null))
            CSKoinLog.I("MainActivity中延迟2秒获取的data的地址" + (data.hashCode()))


            val typeScope2 = getKoin().getScopeOrNull(CSKoinLog.scopeId)
            val typeTwo = typeScope2?.get<ScopeTypeTwo>()
            CSKoinLog.I("MainActivity中延迟2秒获取的ScopeTypeTwo是否为空" + (typeScope2 == null))
            CSKoinLog.I("MainActivity中延迟2秒获取的ScopeTypeTwo地址位:" + (typeTwo.hashCode()))
        }.start()
    }

    override fun onResume() {
        super.onResume()
        Thread {
            Thread.sleep(2000)
            val scopeData2 = getKoin().getScopeOrNull("scopeId1")
            CSKoinLog.I("MainActivity的onResume中获取scope是否为空" + (scopeData2 == null))
        }.start()

    }
}

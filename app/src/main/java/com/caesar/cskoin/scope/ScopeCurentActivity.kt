package com.caesar.cskoin.scope

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caesar.cskoin.CSKoinLog
import com.caesar.cskoin.R
import org.koin.android.ext.android.getKoin
import org.koin.androidx.scope.bindScope
import org.koin.androidx.scope.currentScope
import org.koin.core.qualifier.named

class ScopeCurentActivity : AppCompatActivity() {

    val csopeTypeW: ScopeTypeTwo by currentScope.inject()//直接获取了ScopeTypeTwo对象

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope_curent)
        val scope = getKoin().createScope("scopeId1", named("myScope"))//创建scope方式一
        bindScope(scope)//scope与界面绑定
        val scopeData = scope.get<ScopeData>()//获取作用域下的类
        CSKoinLog.I("ScopeCurentActivity中的ScopeData是否为空:" + (scopeData == null))
        CSKoinLog.I("ScopeCurentActivity中的ScopeData地址:" + (scopeData.hashCode()))

        CSKoinLog.I("ScopeCurentActivity中的ScopeTypeTwo的scopeid值:" + currentScope.id)
        CSKoinLog.scopeId = currentScope.id
        CSKoinLog.I("ScopeCurentActivity中的ScopeTypeTwo的地址位" + (csopeTypeW.hashCode()))


    }
}

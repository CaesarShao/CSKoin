package com.caesar.cskoin

import android.util.Log
import org.koin.core.scope.ScopeID

object CSKoinLog {
    fun I(str: String) {
        Log.i("caesarLogkoin", str)
    }
    var scopeId :ScopeID = ""//保存Scopeid
}

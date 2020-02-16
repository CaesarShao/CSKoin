package com.caesar.cskoin.viewmodel

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.caesar.cskoin.CSKoinLog
import com.caesar.cskoin.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewModelActivity : AppCompatActivity() {
    val myViewModel: MyViewModel by viewModel()
    val myViewModel2 by viewModel<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        CSKoinLog.I(myViewModel.hashCode().toString())
        CSKoinLog.I(myViewModel2.hashCode().toString())
        CSKoinLog.I(myViewModel.NumData.toString())
        findViewById<Button>(R.id.btn_change).setOnClickListener {
            myViewModel.NumData = 1
            CSKoinLog.I(myViewModel.NumData.toString())
        }
    }
}

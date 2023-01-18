package com.incomee.incomee.presentation.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import com.incomee.incomee.R
import com.incomee.incomee.presentation.view.fragment.OperationsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add<OperationsFragment>(R.id.fragment_container_view).commit()
        }
    }
}
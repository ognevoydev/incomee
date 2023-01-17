package com.incomee.incomee.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.incomee.incomee.R
import com.incomee.incomee.presentation.view.fragment.OperationsFragment
import com.incomee.incomee.presentation.view.viewmodel.OperationsViewModel

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
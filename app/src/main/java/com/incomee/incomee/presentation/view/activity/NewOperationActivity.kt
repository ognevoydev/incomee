package com.incomee.incomee.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import com.incomee.incomee.R
import com.incomee.incomee.presentation.view.fragment.NewExpenseFragment
import com.incomee.incomee.presentation.view.fragment.OperationsFragment

class NewOperationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_operation)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add<NewExpenseFragment>(R.id.fragment_container_view).commit()
        }
    }
}
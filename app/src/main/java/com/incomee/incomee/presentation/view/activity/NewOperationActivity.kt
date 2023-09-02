package com.incomee.incomee.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import by.kirich1409.viewbindingdelegate.viewBinding
import com.incomee.incomee.R
import com.incomee.incomee.databinding.ActivityCategoriesBinding
import com.incomee.incomee.databinding.ActivityNewOperationBinding
import com.incomee.incomee.presentation.view.fragment.NewExpenseFragment
import com.incomee.incomee.presentation.view.fragment.OperationsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewOperationActivity : AppCompatActivity() {

    private val binding: ActivityNewOperationBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_operation)

        binding.expenseButton.isActivated = true

        binding.backIconLayout.setOnClickListener {
            binding.backIcon.performClick()
            finish()
        }
    }
}
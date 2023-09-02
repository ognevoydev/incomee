package com.incomee.incomee.presentation.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.incomee.incomee.R
import com.incomee.incomee.databinding.FragmentNewExpenseBinding
import com.incomee.incomee.databinding.FragmentOperationsBinding
import com.incomee.incomee.presentation.view.activity.CategoriesActivity
import com.incomee.incomee.presentation.view.activity.NewOperationActivity

class NewExpenseFragment : Fragment(R.layout.fragment_new_expense) {

    private val binding: FragmentNewExpenseBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.categoryLayout.setOnClickListener {
            val intent = Intent(activity, CategoriesActivity::class.java)
            startActivity(intent)
        }
    }

}
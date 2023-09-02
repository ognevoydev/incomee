package com.incomee.incomee.presentation.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import by.kirich1409.viewbindingdelegate.viewBinding
import com.incomee.incomee.R
import com.incomee.incomee.databinding.FragmentOperationsBinding
import com.incomee.incomee.presentation.view.activity.NewOperationActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OperationsFragment : Fragment(R.layout.fragment_operations) {

    private val binding: FragmentOperationsBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.addOperationFab.setOnClickListener {
            val intent = Intent(activity, NewOperationActivity::class.java)
            startActivity(intent)
        }
    }

}
package com.incomee.incomee.presentation.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.incomee.incomee.R
import com.incomee.incomee.databinding.FragmentOperationFiltersBinding
import com.incomee.incomee.databinding.FragmentOperationsBinding
import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.model.OperationTypeFilter.OperationType
import com.incomee.incomee.presentation.utils.Views.showDialog
import com.incomee.incomee.presentation.view.activity.NewOperationActivity
import com.incomee.incomee.presentation.view.dialog.OnDialogCloseI
import com.incomee.incomee.presentation.view.dialog.OperationTypeDialog
import com.incomee.incomee.presentation.viewmodel.OperationFiltersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OperationFiltersFragment : Fragment(R.layout.fragment_operation_filters), OnDialogCloseI {

    private val binding: FragmentOperationFiltersBinding by viewBinding()
    private val vm: OperationFiltersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.operationTypeFilters.observe(viewLifecycleOwner) {
            setUpOperationTypeFilterText(it)
        }

        setUpFilters()
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.operationTypeFilterButton.setOnClickListener {
            showDialog(OperationTypeDialog(), childFragmentManager, this)
        }

        binding.operationTypeFilterIcon.setOnClickListener {
            operationTypeFilterIconOnClick()
        }
    }

    private fun operationTypeFilterIconOnClick() {
        if (binding.operationTypeFilterButton.isActivated) {
            vm.clearOperationTypeFilters()
            setUpOperationTypeFilter()
        } else showDialog(OperationTypeDialog(), childFragmentManager, this)
    }

    override fun onDialogClose() {
        setUpFilters()
    }

    private fun setUpFilters() {
        setUpOperationTypeFilter()
    }

    private fun setUpOperationTypeFilter() {
        vm.getOperationTypeFilters()
        setUpOperationTypeFilterActivation()
    }

    private fun setUpOperationTypeFilterActivation() {
        binding.operationTypeFilterButton.isActivated =
            vm.operationTypeFilters.value?.size != OperationType.values().size
    }

    private fun setUpOperationTypeFilterText(it: List<OperationTypeFilter>) {
        if (vm.operationTypeFilters.value?.size == OperationType.values().size) {
            binding.operationTypeFilterTextView.text = getString(R.string.operation_type_title)
        } else binding.operationTypeFilterTextView.text = it.joinToString { it.name }
    }

}
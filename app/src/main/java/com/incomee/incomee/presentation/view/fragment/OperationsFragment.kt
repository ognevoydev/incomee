package com.incomee.incomee.presentation.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.incomee.incomee.R
import com.incomee.incomee.databinding.FragmentOperationsBinding
import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.model.OperationTypeFilter.OperationType
import com.incomee.incomee.presentation.utils.Extensions.toFiltersString
import com.incomee.incomee.presentation.utils.Views.showDialog
import com.incomee.incomee.presentation.view.activity.NewOperationActivity
import com.incomee.incomee.presentation.view.dialog.OnDialogCloseI
import com.incomee.incomee.presentation.view.dialog.OperationTypeDialog
import com.incomee.incomee.presentation.viewmodel.OperationsViewModel
import com.incomee.incomee.presentation.viewmodel.factory.OperationsViewModelFactory

class OperationsFragment : Fragment(R.layout.fragment_operations), OnDialogCloseI {

    private val binding: FragmentOperationsBinding by viewBinding()

    private lateinit var vm: OperationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        vm = ViewModelProvider(this, OperationsViewModelFactory(requireContext()))
            .get(OperationsViewModel::class.java)

        return inflater.inflate(R.layout.fragment_operations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.operationTypeFilters.observe(viewLifecycleOwner) {
            setUpOperationTypeFilterText(it)
        }

        setUpFilters()
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.addOperationFab.setOnClickListener {
            val intent = Intent(activity, NewOperationActivity::class.java)
            startActivity(intent)
        }

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
        } else binding.operationTypeFilterTextView.text = it.toFiltersString()
    }

}
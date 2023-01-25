package com.incomee.incomee.presentation.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.incomee.incomee.R
import com.incomee.incomee.databinding.OperationTypeDialogBinding
import com.incomee.incomee.domain.model.OperationTypeFilter.OperationType
import com.incomee.incomee.presentation.utils.Views.changeVisibilityOf
import com.incomee.incomee.presentation.viewmodel.OperationsViewModel
import com.incomee.incomee.presentation.viewmodel.factory.OperationsViewModelFactory


class OperationTypeDialog : DialogI() {

    private val binding: OperationTypeDialogBinding by viewBinding()

    var listener: OnDialogCloseI? = null

    override fun initOnDialogCloseI(listener: OnDialogCloseI) {
        this.listener = listener
    }

    private lateinit var vm: OperationsViewModel

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogStyle
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        vm = ViewModelProvider(requireParentFragment(), OperationsViewModelFactory(requireContext()))
            .get(OperationsViewModel::class.java)

        return inflater.inflate(R.layout.operation_type_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()

        vm.operationTypeFilters.observe(context as LifecycleOwner) {}

        initCheckBoxes()
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.incomeLayout.setOnClickListener { changeVisibilityOf(binding.incomeCheckIcon) }
        binding.expenseLayout.setOnClickListener { changeVisibilityOf(binding.expenseCheckIcon) }
        binding.transferLayout.setOnClickListener { changeVisibilityOf(binding.transferCheckIcon) }

        dialog?.setOnCancelListener {
            updateFilters()
        }

        binding.closeIcon.setOnClickListener {
            updateFilters()
            dismiss()
        }
    }

    private fun initCheckBoxes() {
        vm.getOperationTypeFilters()

        if(vm.operationTypeFilters.value!!.stream().anyMatch{ it.type == OperationType.INCOME })
            changeVisibilityOf(binding.incomeCheckIcon)
        if(vm.operationTypeFilters.value!!.stream().anyMatch{ it.type == OperationType.EXPENSE })
            changeVisibilityOf(binding.expenseCheckIcon)
        if(vm.operationTypeFilters.value!!.stream().anyMatch{ it.type == OperationType.TRANSFER })
            changeVisibilityOf(binding.transferCheckIcon)

    }

    private fun updateFilters() {
        vm.updateOperationTypeIncomeFilter(binding.incomeCheckIcon.isVisible)
        vm.updateOperationTypeExpenseFilter(binding.expenseCheckIcon.isVisible)
        vm.updateOperationTypeTransferFilter(binding.transferCheckIcon.isVisible)
        listener?.onDialogClose()
    }

}
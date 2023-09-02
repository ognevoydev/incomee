package com.incomee.incomee.presentation.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.incomee.incomee.R
import com.incomee.incomee.databinding.OperationTypeDialogBinding
import com.incomee.incomee.domain.model.OperationTypeFilter.OperationType
import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.presentation.utils.Extensions.getLifeCycleOwner
import com.incomee.incomee.presentation.utils.Views.changeVisibilityOf
import com.incomee.incomee.presentation.viewmodel.OperationFiltersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OperationTypeDialog : DialogI() {

    private val binding: OperationTypeDialogBinding by viewBinding()
    private val vm: OperationFiltersViewModel by viewModels(ownerProducer = { requireParentFragment() })

    private var listener: OnDialogCloseI? = null

    override fun initOnDialogCloseI(listener: OnDialogCloseI) {
        this.listener = listener
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogStyle
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.operation_type_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()

        context.getLifeCycleOwner()?.let { vm.operationTypeFilters.observe(it) {} }

        initCheckBoxes()
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.incomeLayout.setOnClickListener {
            changeVisibilityOf(binding.incomeCheckIcon)
            vm.toggleOperationTypeFilter(vm.operationTypes[OperationType.INCOME.value]!!)
        }
        binding.expenseLayout.setOnClickListener {
            changeVisibilityOf(binding.expenseCheckIcon)
            vm.toggleOperationTypeFilter(vm.operationTypes[OperationType.EXPENSE.value]!!)
        }
        binding.transferLayout.setOnClickListener {
            changeVisibilityOf(binding.transferCheckIcon)
            vm.toggleOperationTypeFilter(vm.operationTypes[OperationType.TRANSFER.value]!!)
        }

        dialog?.setOnCancelListener {
            listener?.onDialogClose()
        }

        binding.closeIcon.setOnClickListener {
            listener?.onDialogClose()
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

}
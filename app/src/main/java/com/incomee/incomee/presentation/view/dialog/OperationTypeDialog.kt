package com.incomee.incomee.presentation.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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

    private val b: OperationTypeDialogBinding by viewBinding()

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
        return inflater.inflate(R.layout.operation_type_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()

        vm = ViewModelProvider(requireParentFragment(), OperationsViewModelFactory(requireContext()))
                .get(OperationsViewModel::class.java)

        vm.operationTypeFilters.observe(context as LifecycleOwner) {}

        initCheckBoxes(b.incomeCheckIcon, b.expenseCheckIcon, b.transferCheckIcon)

        b.incomeLayout.setOnClickListener { changeVisibilityOf(b.incomeCheckIcon) }
        b.expenseLayout.setOnClickListener { changeVisibilityOf(b.expenseCheckIcon) }
        b.transferLayout.setOnClickListener { changeVisibilityOf(b.transferCheckIcon) }

        dialog?.setOnCancelListener {
            updateFilters(b.incomeCheckIcon, b.expenseCheckIcon, b.transferCheckIcon)
        }

        b.closeIcon.setOnClickListener {
            updateFilters(b.incomeCheckIcon, b.expenseCheckIcon, b.transferCheckIcon)
            dismiss()
        }
    }

    private fun initCheckBoxes(incomeCheckIcon: ImageView, expenseCheckIcon: ImageView, transferCheckIcon: ImageView) {
        vm.getOperationTypeFilters()

        if (!vm.operationTypeFilters.value.isNullOrEmpty()) {
            for (filter in vm.operationTypeFilters.value!!) {
                if (filter.type == OperationType.INCOME) changeVisibilityOf(incomeCheckIcon)
                if (filter.type == OperationType.EXPENSE) changeVisibilityOf(expenseCheckIcon)
                if (filter.type == OperationType.TRANSFER) changeVisibilityOf(transferCheckIcon)
            }
        }
    }

    private fun updateFilters(incomeCheckIcon: ImageView, expenseCheckIcon: ImageView, transferCheckIcon: ImageView) {
        vm.updateOperationTypeFilters(
            incomeCheckIcon.isVisible, expenseCheckIcon.isVisible, transferCheckIcon.isVisible
        )
        listener?.onDialogClose()
    }

}
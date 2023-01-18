package com.incomee.incomee.presentation.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.incomee.incomee.R
import com.incomee.incomee.domain.model.OperationTypeFilter.OperationType
import com.incomee.incomee.presentation.utils.Views.changeVisibilityOf
import com.incomee.incomee.presentation.viewmodel.OperationsViewModel
import com.incomee.incomee.presentation.viewmodel.factory.OperationsViewModelFactory


class OperationTypeDialog : DialogI() {

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
        return inflater.inflate(R.layout.bottom_sheet_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()

        vm = ViewModelProvider(requireParentFragment(), OperationsViewModelFactory(requireContext()))
            .get(OperationsViewModel::class.java)

        dialog?.let { it ->
            val incomeLayout = it.findViewById<LinearLayout>(R.id.incomeLayout)
            val expenseLayout = it.findViewById<LinearLayout>(R.id.expenseLayout)
            val transferLayout = it.findViewById<LinearLayout>(R.id.transferLayout)
            val incomeCheckIcon = it.findViewById<ImageView>(R.id.incomeCheckIcon)
            val expenseCheckIcon = it.findViewById<ImageView>(R.id.expenseCheckIcon)
            val transferCheckIcon = it.findViewById<ImageView>(R.id.transferCheckIcon)
            val closeIcon = it.findViewById<LinearLayout>(R.id.closeIconLayout)

            vm.operationTypeFilters.observe(context as LifecycleOwner) {}

            initCheckBoxes(incomeCheckIcon, expenseCheckIcon, transferCheckIcon)

            incomeLayout.setOnClickListener { changeVisibilityOf(incomeCheckIcon) }
            expenseLayout.setOnClickListener { changeVisibilityOf(expenseCheckIcon) }
            transferLayout.setOnClickListener { changeVisibilityOf(transferCheckIcon) }

            it.setOnCancelListener {
                updateFilters(incomeCheckIcon, expenseCheckIcon, transferCheckIcon)
            }

            closeIcon.setOnClickListener {
                updateFilters(incomeCheckIcon, expenseCheckIcon, transferCheckIcon)
                dismiss()
            }
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
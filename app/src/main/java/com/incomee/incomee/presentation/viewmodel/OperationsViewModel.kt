package com.incomee.incomee.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.incomee.incomee.R
import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.model.OperationTypeFilter.OperationType
import com.incomee.incomee.domain.usecase.GetOperationTypeFiltersUseCase
import com.incomee.incomee.domain.usecase.UpdateOperationTypeFiltersUseCase
import com.incomee.incomee.presentation.constants.res.DialogRes
import com.incomee.incomee.presentation.utils.Extensions.toComaString

class OperationsViewModel(
    private val res: DialogRes,
    private val updateOperationTypeFiltersUseCase: UpdateOperationTypeFiltersUseCase,
    private val getOperationTypeFiltersUseCase: GetOperationTypeFiltersUseCase
) : ViewModel() {

    private val _operationTypeFilters = MutableLiveData<List<OperationTypeFilter>>()
    val operationTypeFilters: LiveData<List<OperationTypeFilter>> = _operationTypeFilters

    init {
        getOperationTypeFilters()
    }

    fun updateOperationTypeFilters(
        isIncomeChecked: Boolean = true,
        isExpenseChecked: Boolean = true,
        isTransferChecked: Boolean = true
    ) {
        val filters = hashMapOf(
            OperationTypeFilter(res.income, OperationType.INCOME) to isIncomeChecked,
            OperationTypeFilter(res.expense, OperationType.EXPENSE) to isExpenseChecked,
            OperationTypeFilter(res.transfer, OperationType.TRANSFER) to isTransferChecked
        )

        updateOperationTypeFiltersUseCase(filters)
        getOperationTypeFilters()
    }

    private fun getOperationTypeFilters() {
        _operationTypeFilters.value = getOperationTypeFiltersUseCase()
    }

}
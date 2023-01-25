package com.incomee.incomee.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.model.OperationTypeFilter.OperationType
import com.incomee.incomee.domain.usecase.*
import com.incomee.incomee.presentation.constants.res.DialogRes

class OperationsViewModel(
    private val res: DialogRes,
    private val saveOperationTypeFilterUseCase: SaveOperationTypeFilterUseCase,
    private val removeOperationTypeFilterUseCase: RemoveOperationTypeFilterUseCase,
    private val clearOperationTypeFiltersUseCase: ClearOperationTypeFiltersUseCase,
    private val getOperationTypeFiltersUseCase: GetOperationTypeFiltersUseCase
) : ViewModel() {

    private val _operationTypeFilters = MutableLiveData<List<OperationTypeFilter>>()
    val operationTypeFilters: LiveData<List<OperationTypeFilter>> = _operationTypeFilters

    fun updateOperationTypeIncomeFilter(isChecked: Boolean) {
        val filter = OperationTypeFilter(res.income, OperationType.INCOME)
        if(isChecked) saveOperationTypeFilterUseCase(filter)
        else removeOperationTypeFilterUseCase(filter)
    }

    fun updateOperationTypeExpenseFilter(isChecked: Boolean) {
        val filter = OperationTypeFilter(res.expense, OperationType.EXPENSE)
        if(isChecked) saveOperationTypeFilterUseCase(filter)
        else removeOperationTypeFilterUseCase(filter)
    }

    fun updateOperationTypeTransferFilter(isChecked: Boolean) {
        val filter = OperationTypeFilter(res.transfer, OperationType.TRANSFER)
        if(isChecked) saveOperationTypeFilterUseCase(filter)
        else removeOperationTypeFilterUseCase(filter)
    }

    fun clearOperationTypeFilters() {
        clearOperationTypeFiltersUseCase()
    }

    fun getOperationTypeFilters() {
        if(getOperationTypeFiltersUseCase().isEmpty()) {
            updateOperationTypeIncomeFilter(true)
            updateOperationTypeExpenseFilter(true)
            updateOperationTypeTransferFilter(true)
        }
        _operationTypeFilters.value = getOperationTypeFiltersUseCase()
    }

}
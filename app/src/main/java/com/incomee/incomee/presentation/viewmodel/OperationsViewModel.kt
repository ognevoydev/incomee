package com.incomee.incomee.presentation.viewmodel

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.incomee.incomee.R
import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.model.OperationTypeFilter.OperationType
import com.incomee.incomee.domain.usecase.ClearOperationTypeFiltersUseCase
import com.incomee.incomee.domain.usecase.GetOperationTypeFiltersUseCase
import com.incomee.incomee.domain.usecase.RemoveOperationTypeFilterUseCase
import com.incomee.incomee.domain.usecase.SaveOperationTypeFilterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OperationsViewModel @Inject constructor(
    private val res: Resources,
    private val saveOperationTypeFilterUseCase: SaveOperationTypeFilterUseCase,
    private val removeOperationTypeFilterUseCase: RemoveOperationTypeFilterUseCase,
    private val clearOperationTypeFiltersUseCase: ClearOperationTypeFiltersUseCase,
    private val getOperationTypeFiltersUseCase: GetOperationTypeFiltersUseCase
) : ViewModel() {

    private val _operationTypeFilters = MutableLiveData<List<OperationTypeFilter>>()
    val operationTypeFilters: LiveData<List<OperationTypeFilter>> = _operationTypeFilters

    fun updateOperationTypeIncomeFilter(isChecked: Boolean) {
        val filter = OperationTypeFilter(res.getString(R.string.income), OperationType.INCOME)
        if(isChecked) saveOperationTypeFilterUseCase(filter)
        else removeOperationTypeFilterUseCase(filter)
    }

    fun updateOperationTypeExpenseFilter(isChecked: Boolean) {
        val filter = OperationTypeFilter(res.getString(R.string.expense), OperationType.EXPENSE)
        if(isChecked) saveOperationTypeFilterUseCase(filter)
        else removeOperationTypeFilterUseCase(filter)
    }

    fun updateOperationTypeTransferFilter(isChecked: Boolean) {
        val filter = OperationTypeFilter(res.getString(R.string.transfer), OperationType.TRANSFER)
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
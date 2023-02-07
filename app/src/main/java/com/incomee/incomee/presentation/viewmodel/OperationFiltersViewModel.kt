package com.incomee.incomee.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.usecase.ClearOperationTypeFiltersUseCase
import com.incomee.incomee.domain.usecase.GetOperationTypeFiltersUseCase
import com.incomee.incomee.domain.usecase.ToggleOperationTypeFilterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class OperationFiltersViewModel @Inject constructor(
    private val toggleOperationTypeFilterUseCase: ToggleOperationTypeFilterUseCase,
    private val clearOperationTypeFiltersUseCase: ClearOperationTypeFiltersUseCase,
    private val getOperationTypeFiltersUseCase: GetOperationTypeFiltersUseCase
) : ViewModel() {

    @Inject
    @Named("OperationTypesList")
    lateinit var operationTypes: HashMap<String, OperationTypeFilter>

    private val _operationTypeFilters = MutableLiveData<List<OperationTypeFilter>>()
    val operationTypeFilters: LiveData<List<OperationTypeFilter>> = _operationTypeFilters

    fun toggleOperationTypeFilter(filter: OperationTypeFilter) {
        toggleOperationTypeFilterUseCase(filter)
    }

    fun clearOperationTypeFilters() {
        clearOperationTypeFiltersUseCase()
    }

    fun getOperationTypeFilters() {
        if(getOperationTypeFiltersUseCase().isEmpty()) {
            for(filter in operationTypes) {
                toggleOperationTypeFilterUseCase(filter.value)
            }
        }
        _operationTypeFilters.value = getOperationTypeFiltersUseCase()
    }

}
package com.incomee.incomee.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.incomee.incomee.data.model.mapper.OperationMapper
import com.incomee.incomee.data.repository.OperationRepositoryImpl
import com.incomee.incomee.domain.usecase.AddOperationUseCase

class OperationsViewModelFactory : ViewModelProvider.Factory {

    private val operationMapper = OperationMapper()
    private val operationRepository = OperationRepositoryImpl(operationMapper)

    private val addOperationUseCase = AddOperationUseCase(operationRepository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OperationsViewModel(addOperationUseCase = addOperationUseCase) as T
    }
}
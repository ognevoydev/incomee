package com.incomee.incomee.presentation.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.incomee.incomee.data.repository.OperationTypeFilterRepositoryImpl
import com.incomee.incomee.data.repository.storage.OperationTypeFilterStorage
import com.incomee.incomee.domain.usecase.*
import com.incomee.incomee.presentation.constants.res.DialogRes
import com.incomee.incomee.presentation.viewmodel.OperationsViewModel

class OperationsViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val dialogRes = DialogRes(context.resources)
    private val operationTypeFilterStorage = OperationTypeFilterStorage(context)
    private val filterRepository = OperationTypeFilterRepositoryImpl(operationTypeFilterStorage)
    private val saveOperationTypeFilterUseCase = SaveOperationTypeFilterUseCase(filterRepository)
    private val removeOperationTypeFilterUseCase = RemoveOperationTypeFilterUseCase(filterRepository)
    private val clearOperationTypeFiltersUseCase = ClearOperationTypeFiltersUseCase(filterRepository)
    private val getOperationTypeFiltersUseCase = GetOperationTypeFiltersUseCase(filterRepository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OperationsViewModel(
            res = dialogRes,
            saveOperationTypeFilterUseCase = saveOperationTypeFilterUseCase,
            removeOperationTypeFilterUseCase = removeOperationTypeFilterUseCase,
            clearOperationTypeFiltersUseCase = clearOperationTypeFiltersUseCase,
            getOperationTypeFiltersUseCase = getOperationTypeFiltersUseCase
        ) as T
    }
}
package com.incomee.incomee.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.incomee.incomee.data.model.mapper.OperationMapper
import com.incomee.incomee.data.repository.OperationRepositoryImpl
import com.incomee.incomee.domain.model.Operation
import com.incomee.incomee.domain.usecase.AddOperationUseCase

class OperationsViewModel(private val addOperationUseCase: AddOperationUseCase
) : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result


    fun addOperation(operation: Operation) {
        addOperationUseCase(operation)
    }

//    fun getFoo(id: Long) {
//        result.value = getFooUseCase(id)
//    }

}
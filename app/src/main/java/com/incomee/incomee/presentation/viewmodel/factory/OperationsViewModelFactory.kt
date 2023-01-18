package com.incomee.incomee.presentation.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.incomee.incomee.presentation.viewmodel.OperationsViewModel

class OperationsViewModelFactory(context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OperationsViewModel() as T
    }
}
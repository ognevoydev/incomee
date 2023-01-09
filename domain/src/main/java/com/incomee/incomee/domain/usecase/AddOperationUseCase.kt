package com.incomee.incomee.domain.usecase

import com.incomee.incomee.domain.model.Operation
import com.incomee.incomee.domain.repository.OperationRepository

class AddOperationUseCase(private val operationRepository: OperationRepository) {

   operator fun invoke(operation: Operation) {
        //TODO
    }

}
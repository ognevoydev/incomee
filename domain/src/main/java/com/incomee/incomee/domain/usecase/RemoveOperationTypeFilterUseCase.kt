package com.incomee.incomee.domain.usecase

import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.repository.OperationTypeFilterRepository

class UpdateOperationTypeFilterUseCase(private val operationTypeFilterRepository: OperationTypeFilterRepository) {

    operator fun invoke(filter: OperationTypeFilter) {
        if(filter.isActive)
            operationTypeFilterRepository.save(filter)
        else
            operationTypeFilterRepository.remove(filter)
    }
}
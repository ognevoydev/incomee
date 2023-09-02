package com.incomee.incomee.domain.usecase

import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.repository.OperationTypeFilterRepository

class GetOperationTypeFiltersUseCase(private val operationTypeFilterRepository: OperationTypeFilterRepository) {

    operator fun invoke(): List<OperationTypeFilter> {
        return operationTypeFilterRepository.get()
    }
}
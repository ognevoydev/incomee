package com.incomee.incomee.domain.usecase

import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.repository.OperationTypeFilterRepository

class CleanOperationTypeFiltersUseCase(private val operationTypeFilterRepository: OperationTypeFilterRepository) {

    operator fun invoke() {
        operationTypeFilterRepository.clean()
    }
}
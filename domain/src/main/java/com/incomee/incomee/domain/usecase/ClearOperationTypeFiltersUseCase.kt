package com.incomee.incomee.domain.usecase

import com.incomee.incomee.domain.repository.OperationTypeFilterRepository

class ClearOperationTypeFiltersUseCase(private val operationTypeFilterRepository: OperationTypeFilterRepository) {

    operator fun invoke() {
        operationTypeFilterRepository.clear()
    }
}
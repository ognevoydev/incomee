package com.incomee.incomee.domain.usecase

import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.repository.OperationTypeFilterRepository

class ToggleOperationTypeFilterUseCase(private val operationTypeFilterRepository: OperationTypeFilterRepository) {

    operator fun invoke(filter: OperationTypeFilter) {
        operationTypeFilterRepository.toggle(filter)
    }
}
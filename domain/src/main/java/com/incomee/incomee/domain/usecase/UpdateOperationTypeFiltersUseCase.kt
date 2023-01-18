package com.incomee.incomee.domain.usecase

import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.repository.OperationTypeFilterRepository

class UpdateOperationTypeFiltersUseCase(private val operationTypeFilterRepository: OperationTypeFilterRepository) {

    operator fun invoke(filters: HashMap<OperationTypeFilter, Boolean>) {
        var toSave = filters.entries.partition { it.value }.first.map { it.key }
        var toRemove = filters.entries.partition { it.value }.second.map { it.key }

        toSave.ifEmpty {
            toSave = toRemove.also { toRemove = toSave }
        }

        operationTypeFilterRepository.remove(toRemove)
        operationTypeFilterRepository.save(toSave)
    }
}
package com.incomee.incomee.data.repository

import com.incomee.incomee.data.repository.storage.FilterStorage
import com.incomee.incomee.data.utils.Extensions.mapToDomain
import com.incomee.incomee.data.utils.Extensions.mapToEntity
import com.incomee.incomee.domain.model.OperationTypeFilter
import com.incomee.incomee.domain.repository.OperationTypeFilterRepository
import kotlin.streams.toList

class OperationTypeFilterRepositoryImpl(private val filterStorage: FilterStorage) :
    OperationTypeFilterRepository {

    override fun save(filter: OperationTypeFilter) {
        filterStorage.save(filter.mapToEntity())
    }

    override fun remove(filter: OperationTypeFilter) {
        filterStorage.remove(filter.mapToEntity())
    }

    override fun clear() {
        filterStorage.clear()
    }

    override fun get(): List<OperationTypeFilter> {
        return filterStorage.get().stream().map{ it.mapToDomain() }.toList()
    }

}
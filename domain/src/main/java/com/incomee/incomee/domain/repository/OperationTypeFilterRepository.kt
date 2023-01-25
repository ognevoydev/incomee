package com.incomee.incomee.domain.repository

import com.incomee.incomee.domain.model.OperationTypeFilter

interface OperationTypeFilterRepository {

    fun save(filter: OperationTypeFilter)
    fun remove(filter: OperationTypeFilter)
    fun clear()
    fun get(): List<OperationTypeFilter>

}
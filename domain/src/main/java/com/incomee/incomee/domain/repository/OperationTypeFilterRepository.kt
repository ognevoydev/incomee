package com.incomee.incomee.domain.repository

import com.incomee.incomee.domain.model.OperationTypeFilter

interface OperationTypeFilterRepository {

    fun save(filters: List<OperationTypeFilter>)
    fun remove(filters: List<OperationTypeFilter>)
    fun get(): List<OperationTypeFilter>

}
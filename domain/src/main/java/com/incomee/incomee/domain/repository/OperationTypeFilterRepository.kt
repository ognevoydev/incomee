package com.incomee.incomee.domain.repository

import com.incomee.incomee.domain.model.OperationTypeFilter

interface OperationTypeFilterRepository {

    fun toggle(filter: OperationTypeFilter)
    fun clear()
    fun get(): List<OperationTypeFilter>

}
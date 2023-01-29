package com.incomee.incomee.data.repository.storage

import com.incomee.incomee.data.model.OperationTypeFilterEntity

interface FilterStorage {

    fun toggle(filter: OperationTypeFilterEntity)
    fun clear()
    fun get(): List<OperationTypeFilterEntity>

}
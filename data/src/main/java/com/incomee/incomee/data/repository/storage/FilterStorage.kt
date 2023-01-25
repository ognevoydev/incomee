package com.incomee.incomee.data.repository.storage

import com.incomee.incomee.data.model.OperationTypeFilterEntity

interface FilterStorage {

    fun save(filter: OperationTypeFilterEntity)
    fun remove(filter: OperationTypeFilterEntity)
    fun clear()
    fun get(): List<OperationTypeFilterEntity>

}
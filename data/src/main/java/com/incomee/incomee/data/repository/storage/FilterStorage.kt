package com.incomee.incomee.data.repository.storage

import com.incomee.incomee.data.model.OperationTypeFilterEntity

interface FilterStorage {

    fun save(filters: List<OperationTypeFilterEntity>)
    fun remove(filters: List<OperationTypeFilterEntity>)
    fun get(): List<OperationTypeFilterEntity>

}
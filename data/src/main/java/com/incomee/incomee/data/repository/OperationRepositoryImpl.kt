package com.incomee.incomee.data.repository

import com.incomee.incomee.data.model.mapper.OperationMapper
import com.incomee.incomee.domain.model.Operation
import com.incomee.incomee.domain.repository.OperationRepository

class OperationRepositoryImpl (private val mapper: OperationMapper) : OperationRepository {

    override fun save(operation: Operation) {
        //TODO
        mapper.toEntity(operation)
    }

}
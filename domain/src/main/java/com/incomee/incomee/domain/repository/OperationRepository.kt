package com.incomee.incomee.domain.repository

import com.incomee.incomee.domain.model.Operation

interface OperationRepository {

    fun save(operation: Operation)

}
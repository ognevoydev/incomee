package com.incomee.incomee.data.repository

import com.incomee.incomee.data.dao.OperationDao
import com.incomee.incomee.domain.repository.OperationRepository
import javax.inject.Inject

class OperationRepositoryImpl @Inject constructor(private val dao: OperationDao) :
    OperationRepository {

}
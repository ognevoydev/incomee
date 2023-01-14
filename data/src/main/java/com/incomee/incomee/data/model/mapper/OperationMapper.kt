package com.incomee.incomee.data.model.mapper

import com.incomee.incomee.data.model.OperationEntity
import com.incomee.incomee.domain.model.Operation

class OperationMapper : BaseMapper<Operation, OperationEntity> {

    override fun toEntity(value: Operation): OperationEntity {
        //TODO
        return OperationEntity()
    }

    override fun toDomain(value: OperationEntity): Operation {
        //TODO
        return Operation()
    }

}
package com.incomee.incomee.data.utils

import com.incomee.incomee.data.model.OperationTypeFilterEntity
import com.incomee.incomee.domain.model.OperationTypeFilter

object Extensions {

    fun List<OperationTypeFilterEntity>.mapToDomain(): List<OperationTypeFilter> {
        val domain = ArrayList<OperationTypeFilter>()
        for(e in this) {
            domain.add(OperationTypeFilter(name = e.name, type = e.type.mapToDomain()))
        }
        return domain
    }

    fun List<OperationTypeFilter>.mapToEntity(): List<OperationTypeFilterEntity> {
        val entity = ArrayList<OperationTypeFilterEntity>()
        for(e in this) {
            entity.add(OperationTypeFilterEntity(name = e.name, type = e.type.mapToEntity()))
        }
        return entity
    }

    fun OperationTypeFilterEntity.OperationType.mapToDomain() : OperationTypeFilter.OperationType {
        return OperationTypeFilter.OperationType.valueOf(this.name)
    }

    fun OperationTypeFilter.OperationType.mapToEntity() : OperationTypeFilterEntity.OperationType {
        return OperationTypeFilterEntity.OperationType.valueOf(this.name)
    }

}
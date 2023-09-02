package com.incomee.incomee.data.utils

import com.incomee.incomee.data.model.OperationTypeFilterEntity
import com.incomee.incomee.domain.model.OperationTypeFilter

object Extensions {

    fun OperationTypeFilterEntity.mapToDomain() : OperationTypeFilter {
        return OperationTypeFilter(this.name, this.type.mapToDomain())
    }

    fun OperationTypeFilter.mapToEntity() : OperationTypeFilterEntity {
        return OperationTypeFilterEntity(this.name, this.type.mapToEntity())
    }

    fun OperationTypeFilterEntity.OperationType.mapToDomain() : OperationTypeFilter.OperationType {
        return OperationTypeFilter.OperationType.valueOf(this.name)
    }

    fun OperationTypeFilter.OperationType.mapToEntity() : OperationTypeFilterEntity.OperationType {
        return OperationTypeFilterEntity.OperationType.valueOf(this.name)
    }

}
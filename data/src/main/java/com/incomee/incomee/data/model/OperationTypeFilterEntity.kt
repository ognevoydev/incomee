package com.incomee.incomee.data.model

class OperationTypeFilterEntity(val name: String, val type: OperationType) {

    enum class OperationType(val value: String) {
        INCOME("income"),
        EXPENSE("expense"),
        TRANSFER("transfer")
    }

}
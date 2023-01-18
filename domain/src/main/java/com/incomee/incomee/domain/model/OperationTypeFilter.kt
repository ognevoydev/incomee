package com.incomee.incomee.domain.model

class OperationTypeFilter(val name: String, val type: OperationType) {

    enum class OperationType(val value: String) {
        INCOME("income"),
        EXPENSE("expense"),
        TRANSFER("transfer")
    }

}
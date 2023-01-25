package com.incomee.incomee.presentation.utils

import com.incomee.incomee.domain.model.OperationTypeFilter

object Extensions {

    fun List<OperationTypeFilter>.toFiltersString(): String {
        val sb = StringBuilder()
        for(el in this) {
            sb.append(el.name)
            if(indexOf(el) != (this.size - 1)) sb.append(", ")
        }
        return sb.toString()
    }

}
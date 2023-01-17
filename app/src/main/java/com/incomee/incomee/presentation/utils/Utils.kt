package com.incomee.incomee.presentation.utils

import android.view.View
import com.incomee.incomee.domain.model.OperationTypeFilter

object Utils {

    fun List<OperationTypeFilter>.toComaString(): String {
        val sb = StringBuilder()
        for(el in this) {
            sb.append(el.name)
            if(indexOf(el) != (this.size - 1)) sb.append(", ")
        }
        return sb.toString()
    }

    fun changeVisibilityOf(view: View) {
        if(view.visibility == View.VISIBLE) {
            view.visibility = View.INVISIBLE
        } else
            view.visibility = View.VISIBLE
    }



}
package com.incomee.incomee.presentation.utils

import android.view.View
import androidx.fragment.app.FragmentManager
import com.incomee.incomee.presentation.view.dialog.DialogI
import com.incomee.incomee.presentation.view.dialog.OnDialogCloseI

object Views {

    private const val TAG = "tag"

    fun changeVisibilityOf(view: View) {
        if(view.visibility == View.VISIBLE) {
            view.visibility = View.INVISIBLE
        } else
            view.visibility = View.VISIBLE
    }

    fun showDialog(dialog: DialogI, fragmentManager: FragmentManager, listener: OnDialogCloseI) {
        dialog.show(fragmentManager, TAG)
        dialog.initOnDialogCloseI(listener)
    }

}
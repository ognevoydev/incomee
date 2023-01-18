package com.incomee.incomee.presentation.view.dialog

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class DialogI : BottomSheetDialogFragment() {
    open fun initOnDialogCloseI(listener: OnDialogCloseI) {}
}
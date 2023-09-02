package com.incomee.incomee.presentation.adapter

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.incomee.incomee.R

class BottomDividerDecorator(
    context: Context
) : RecyclerView.ItemDecoration() {
    val drawable: Drawable = ContextCompat.getDrawable(context, R.drawable.divider)!!

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.adapter!!.itemCount
        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)
            if (child != null) {
                val params = child.layoutParams as RecyclerView.LayoutParams
                val top = child.bottom + params.bottomMargin
                val bottom = top + drawable.intrinsicHeight
                drawable.setBounds(left, top, right, bottom)
                drawable.draw(c)
            }
        }
    }
}
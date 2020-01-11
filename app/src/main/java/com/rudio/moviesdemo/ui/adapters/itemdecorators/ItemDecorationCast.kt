package com.rudio.moviesdemo.ui.adapters.itemdecorators

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecorationCast(private val size: Int = 4) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val density = parent.context?.resources?.displayMetrics?.density ?: 1.5F
        val margin = (density * size).toInt()
        outRect.left = if (position == 0) margin else 0
        outRect.top = 0
        outRect.right = margin
        outRect.bottom = 0
    }
}
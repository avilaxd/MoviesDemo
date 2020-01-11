package com.rudio.moviesdemo.ui.adapters.itemdecorators

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecorationMovies(
    private val size: Int = 8,
    private val spanCount: Int = 2
) : RecyclerView.ItemDecoration() {

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
        val marginHalf = (margin / 2)
        val marginTop = when (position) {
            in 0 until spanCount -> margin
            else -> 0
        }
        outRect.left = if (position % 2 == 0) margin else marginHalf
        outRect.top = marginTop
        outRect.right = if (position % 2 == 0) marginHalf else margin
        outRect.bottom = margin
    }
}
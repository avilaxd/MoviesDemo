
package com.rudio.moviesdemo.ui.adapters.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Backdrop
import com.rudio.moviesdemo.utils.PicassoHelper
import com.rudio.moviesdemo.utils.prependBackdropPath
import kotlinx.android.synthetic.main.holder_backdrop.view.*

class HolderBackdrop(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(backdrop: Backdrop) {
        PicassoHelper.setImage(
            itemView.imageBackdrop,
            backdrop.path?.prependBackdropPath() ?: "",
            R.drawable.placeholder_backdrop)
    }
}
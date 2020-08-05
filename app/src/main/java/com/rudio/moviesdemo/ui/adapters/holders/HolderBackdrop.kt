
package com.rudio.moviesdemo.ui.adapters.holders

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.data.models.Backdrop
import com.rudio.moviesdemo.databinding.HolderBackdropBinding
import com.rudio.moviesdemo.utils.prependBackdropPath

class HolderBackdrop(
    private val binding: HolderBackdropBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(backdrop: Backdrop) {
        binding.urlBackdrop = backdrop.path.prependBackdropPath()
        binding.executePendingBindings()
    }
}
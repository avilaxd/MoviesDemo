
package com.rudio.moviesdemo.presentation.features.moviedetail

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderBackdropBinding
import com.rudio.moviesdemo.presentation.models.BackdropUi

class HolderBackdrop(
    private val binding: HolderBackdropBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(backdrop: BackdropUi) {
        binding.backdrop = backdrop
        binding.executePendingBindings()
    }
}
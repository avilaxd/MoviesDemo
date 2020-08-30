
package com.rudio.moviesdemo.presentation.features.moviedetail

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderBackdropBinding
import com.rudio.moviesdemo.domain.models.IBackdrop
import com.rudio.moviesdemo.presentation.utils.prependBackdropPath

class HolderBackdrop(
    private val binding: HolderBackdropBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(backdrop: IBackdrop) {
        binding.urlBackdrop = backdrop.path.prependBackdropPath()
        binding.executePendingBindings()
    }
}
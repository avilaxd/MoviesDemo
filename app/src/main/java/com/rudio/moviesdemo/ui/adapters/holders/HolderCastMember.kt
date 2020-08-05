package com.rudio.moviesdemo.ui.adapters.holders

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.data.models.CastMember
import com.rudio.moviesdemo.databinding.HolderCastmemberBinding
import com.rudio.moviesdemo.utils.prependCastPath

class HolderCastMember(
    private val binding: HolderCastmemberBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(castMember: CastMember) {
        binding.castMember = castMember
        binding.urlCast = castMember.picture.prependCastPath()
        binding.executePendingBindings()
    }
}
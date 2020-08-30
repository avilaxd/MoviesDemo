package com.rudio.moviesdemo.presentation.features.moviedetail

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderCastmemberBinding
import com.rudio.moviesdemo.domain.models.ICastMember
import com.rudio.moviesdemo.presentation.utils.prependCastPath

class HolderCastMember(
    private val binding: HolderCastmemberBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(castMember: ICastMember) {
        binding.castMember = castMember
        binding.urlCast = castMember.picture.prependCastPath()
        binding.executePendingBindings()
    }
}
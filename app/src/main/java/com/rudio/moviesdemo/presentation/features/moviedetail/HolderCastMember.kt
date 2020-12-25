package com.rudio.moviesdemo.presentation.features.moviedetail

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderCastmemberBinding
import com.rudio.moviesdemo.presentation.models.CastMemberUi

class HolderCastMember(
    private val binding: HolderCastmemberBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(castMember: CastMemberUi) {
        binding.castMember = castMember
        binding.executePendingBindings()
    }
}
package com.rudio.moviesdemo.presentation.features.favorites

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderFavoriteBinding
import com.rudio.moviesdemo.presentation.models.MovieUi

class HolderFavorite(
    private val binding: HolderFavoriteBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(viewModel: ViewModelFavorites, favorite: MovieUi) {
        binding.viewModel = viewModel
        binding.favorite = favorite
        binding.executePendingBindings()
    }
}
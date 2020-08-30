package com.rudio.moviesdemo.presentation.features.favorites

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderFavoriteBinding
import com.rudio.moviesdemo.domain.models.IMovie
import com.rudio.moviesdemo.presentation.utils.prependPosterPath
import com.rudio.moviesdemo.presentation.features.favorites.ViewModelFavorites

class HolderFavorite(
    private val binding: HolderFavoriteBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(viewModel: ViewModelFavorites, favorite: IMovie) {
        binding.viewModel = viewModel
        binding.favorite = favorite
        binding.urlPoster = favorite.poster.prependPosterPath()
        binding.executePendingBindings()
    }
}
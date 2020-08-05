package com.rudio.moviesdemo.ui.adapters.holders

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.databinding.HolderFavoriteBinding
import com.rudio.moviesdemo.utils.prependPosterPath
import com.rudio.moviesdemo.viewmodels.ViewModelFavorites

class HolderFavorite(
    private val binding: HolderFavoriteBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(viewModel: ViewModelFavorites, favorite: Movie) {
        binding.viewModel = viewModel
        binding.favorite = favorite
        binding.urlPoster = favorite.poster.prependPosterPath()
        binding.executePendingBindings()
    }
}
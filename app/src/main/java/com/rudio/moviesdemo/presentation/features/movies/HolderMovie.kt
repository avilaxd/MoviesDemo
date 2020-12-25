package com.rudio.moviesdemo.presentation.features.movies

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderMovieBinding
import com.rudio.moviesdemo.presentation.models.MovieUi

class HolderMovie(
    private val binding: HolderMovieBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(viewModel: ViewModelMovies, movie: MovieUi) {
        binding.viewModel = viewModel
        binding.movie = movie
        binding.executePendingBindings()
    }
}
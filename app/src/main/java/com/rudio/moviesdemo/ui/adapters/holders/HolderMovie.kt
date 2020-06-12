package com.rudio.moviesdemo.ui.adapters.holders

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.databinding.HolderMovieBinding
import com.rudio.moviesdemo.utils.prependPosterPath
import com.rudio.moviesdemo.viewmodels.ViewModelMovies

class HolderMovie(
    private val binding: HolderMovieBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(viewModel: ViewModelMovies, movie: Movie) {
        binding.viewModel = viewModel
        binding.movie = movie
        binding.urlPoster = movie.poster?.prependPosterPath()
        binding.executePendingBindings()
    }
}
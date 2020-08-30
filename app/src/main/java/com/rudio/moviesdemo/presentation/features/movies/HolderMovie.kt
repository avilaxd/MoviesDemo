package com.rudio.moviesdemo.presentation.features.movies

import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderMovieBinding
import com.rudio.moviesdemo.domain.models.IMovie
import com.rudio.moviesdemo.presentation.utils.prependPosterPath
import com.rudio.moviesdemo.presentation.features.movies.ViewModelMovies

class HolderMovie(
    private val binding: HolderMovieBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(viewModel: ViewModelMovies, movie: IMovie) {
        binding.viewModel = viewModel
        binding.movie = movie
        binding.urlPoster = movie.poster.prependPosterPath()
        binding.executePendingBindings()
    }
}
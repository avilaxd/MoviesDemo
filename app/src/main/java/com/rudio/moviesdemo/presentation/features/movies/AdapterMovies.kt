package com.rudio.moviesdemo.presentation.features.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderMovieBinding
import com.rudio.moviesdemo.presentation.models.MovieUi

class AdapterMovies(
    private val viewModel: ViewModelMovies,
    private var movies: List<MovieUi> = listOf()
) : RecyclerView.Adapter<HolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMovie {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderMovieBinding.inflate(layoutInflater, parent, false)
        return HolderMovie(
            binding
        )
    }

    fun setMovies(movies: List<MovieUi>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: HolderMovie, position: Int) {
        holder.onBind(viewModel, movies[position])
    }
}
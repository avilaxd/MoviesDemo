package com.rudio.moviesdemo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.interfaces.OnClickMovie
import com.rudio.moviesdemo.ui.adapters.holders.HolderMovie

class AdapterMovies(
    private val movies: List<Movie>,
    private val onClickMovie: OnClickMovie
) : RecyclerView.Adapter<HolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMovie {
        return HolderMovie(LayoutInflater.from(parent.context).inflate(R.layout.holder_movie, parent, false), onClickMovie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: HolderMovie, position: Int) {
        holder.onBind(movies[position])
    }
}
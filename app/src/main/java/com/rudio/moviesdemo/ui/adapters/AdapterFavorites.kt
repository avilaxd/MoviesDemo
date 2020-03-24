package com.rudio.moviesdemo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.interfaces.OnClickMovie
import com.rudio.moviesdemo.interfaces.OnDeleteMovie
import com.rudio.moviesdemo.ui.adapters.holders.HolderFavorite

class AdapterFavorites(
    private val movies: List<Movie>,
    private val onClickMovie: OnClickMovie,
    private val onDeleteMovie: OnDeleteMovie
) : RecyclerView.Adapter<HolderFavorite>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderFavorite {
        return HolderFavorite(LayoutInflater.from(parent.context).inflate(R.layout.holder_favorite, parent, false), onClickMovie, onDeleteMovie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: HolderFavorite, position: Int) {
        holder.onBind(movies[position])
    }
}
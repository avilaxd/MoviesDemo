package com.rudio.moviesdemo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.databinding.HolderFavoriteBinding
import com.rudio.moviesdemo.ui.adapters.holders.HolderFavorite
import com.rudio.moviesdemo.viewmodels.ViewModelFavorites

class AdapterFavorites(
    private val viewModel: ViewModelFavorites,
    private var favorites: List<Movie> = listOf()
) : RecyclerView.Adapter<HolderFavorite>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderFavorite {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderFavoriteBinding.inflate(layoutInflater, parent, false)
        return HolderFavorite(binding)
    }

    fun setFavorites(favorites: List<Movie>) {
        this.favorites = favorites
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return favorites.size
    }

    override fun onBindViewHolder(holder: HolderFavorite, position: Int) {
        holder.onBind(viewModel, favorites[position])
    }
}
package com.rudio.moviesdemo.ui.adapters.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.interfaces.OnClickMovie
import com.rudio.moviesdemo.utils.PicassoHelper
import com.rudio.moviesdemo.utils.prependPosterPath
import kotlinx.android.synthetic.main.holder_movie.view.*

class HolderMovie(
    itemView: View,
    private val onClickMovie: OnClickMovie
) : RecyclerView.ViewHolder(itemView) {

    fun onBind(movie: Movie) {
        itemView.setOnClickListener { onClickMovie.onClick(movie) }
        itemView.textTitle.text = movie.title
        itemView.textVotes.text = movie.votesAverage.toString()
        PicassoHelper.setImage(
            itemView.imagePoster,
            movie.poster?.prependPosterPath() ?: "",
            R.drawable.placeholder_poster)
    }
}
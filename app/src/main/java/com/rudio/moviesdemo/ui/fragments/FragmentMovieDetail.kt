package com.rudio.moviesdemo.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.ui.adapters.AdapterBackdrops
import com.rudio.moviesdemo.ui.adapters.AdapterCast
import com.rudio.moviesdemo.ui.adapters.itemdecorators.ItemDecorationCast
import com.rudio.moviesdemo.utils.PicassoHelper
import com.rudio.moviesdemo.utils.TextViewHelper
import com.rudio.moviesdemo.utils.getAppComponent
import com.rudio.moviesdemo.utils.prependPosterPath
import com.rudio.moviesdemo.viewmodels.ViewModelFactory
import com.rudio.moviesdemo.viewmodels.ViewModelMovieDetail
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import javax.inject.Inject

class FragmentMovieDetail : Fragment(R.layout.fragment_movie_detail) {
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var movie: Movie
    private lateinit var viewModel: ViewModelMovieDetail

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getAppComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie = arguments?.getParcelable("movie") ?: Movie()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TextViewHelper.enableScroll(textSynopsisBody)
        recyclerCast.addItemDecoration(ItemDecorationCast())
        toggleFavorite.setOnClickListener { setFavorite(movie) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelMovieDetail::class.java]
        startObserving(viewModel)
        viewModel.setMovie(movie)
        viewModel.fetchBackdrops(movie.id)
        viewModel.fetchCast(movie.id)
    }

    private fun startObserving(viewModel: ViewModelMovieDetail) {
        viewModel.getMovie().observe(viewLifecycleOwner, Observer { movie ->
            updateUI(movie)
        })
        viewModel.getBackdrops().observe(viewLifecycleOwner, Observer { backdrops ->
            updateUIBackdrops(AdapterBackdrops(backdrops))
        })

        viewModel.getCast().observe(viewLifecycleOwner, Observer { cast ->
            updateUICast(AdapterCast(cast))
        })
    }

    private fun updateUI(movie: Movie) {
        textTitle.text = movie.title
        textSynopsisBody.text = movie.overview
        textVotes.text = movie.votesAverage.toString()
        textDateBody.text = movie.date
        textLanguageBody.text = movie.language
        PicassoHelper.setImage(imagePoster, movie.poster?.prependPosterPath() ?: "", R.drawable.placeholder_poster)
        setToggleFavorite(isFavorite(movie))
    }

    private fun updateUIBackdrops(adapterBackdrops: AdapterBackdrops) {
        pagerImages.adapter = adapterBackdrops
    }

    private fun updateUICast(adapterCast: AdapterCast) {
        recyclerCast.adapter = adapterCast
    }

    private fun isFavorite(movie: Movie): Boolean {
        return viewModel.isFavorite(movie.id).isNotEmpty()
    }

    private fun setToggleFavorite(isChecked: Boolean) {
        toggleFavorite.isChecked = isChecked
    }

    private fun setFavorite(movie: Movie) {
        //It uses '!' because it first dispatches the click to the normal
        //behaviour of the toggle changing it's "isChecked" state
        if (!toggleFavorite.isChecked) {
            viewModel.deleteFavorite(movie)
        } else {
            viewModel.insertFavorite(movie)
        }
    }
}
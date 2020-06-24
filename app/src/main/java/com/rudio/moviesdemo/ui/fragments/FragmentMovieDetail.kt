package com.rudio.moviesdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.databinding.FragmentMovieDetailBinding
import com.rudio.moviesdemo.ui.adapters.AdapterBackdrops
import com.rudio.moviesdemo.ui.adapters.AdapterCast
import com.rudio.moviesdemo.ui.adapters.itemdecorators.ItemDecorationCast
import com.rudio.moviesdemo.viewmodels.ViewModelMovieDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentMovieDetail : Fragment() {
    private lateinit var movie: Movie
    private val viewModel: ViewModelMovieDetail by viewModels()
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movie = arguments?.getParcelable("movie") ?: Movie()
        viewModel.setMovie(movie)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.itemDecoration = ItemDecorationCast()
        binding.recyclerCast.adapter = AdapterCast()
        binding.pagerImages.adapter = AdapterBackdrops()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startObserving()
        viewModel.fetchIsFavorite(movie.id)
        viewModel.fetchBackdrops(movie.id)
        viewModel.fetchCast(movie.id)
    }

    private fun startObserving() {
        viewModel.getEventOnClickFavorite().observe(viewLifecycleOwner, Observer { event ->
            setFavorite(event.getValue())
        })
    }

    private fun setFavorite(movie: Movie) {
        if (viewModel.getIsFavorite().value == true) {
            viewModel.deleteFavorite(movie)
        } else {
            viewModel.insertFavorite(movie)
        }
    }
}
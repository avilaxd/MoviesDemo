package com.rudio.moviesdemo.presentation.features.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.databinding.FragmentMovieDetailBinding
import com.rudio.moviesdemo.presentation.models.MovieUi
import com.rudio.moviesdemo.presentation.utils.ItemDecorationCast
import com.rudio.moviesdemo.presentation.utils.API_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentMovieDetail : Fragment() {
    private lateinit var movie: MovieUi
    private val viewModel: ViewModelMovieDetail by viewModels()
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movie = arguments?.getParcelable("movie") ?: MovieUi()
        viewModel.setMovie(movie)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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
        viewModel.fetchBackdrops(movie.id, API_KEY)
        viewModel.fetchCast(movie.id, API_KEY)
    }

    private fun startObserving() {
        viewModel.getEventOnClickFavorite().observe(viewLifecycleOwner, { event ->
            setFavorite(event.getValue())
        })
    }

    private fun setFavorite(movie: MovieUi) {
        if (viewModel.getIsFavorite().value == true) {
            viewModel.deleteFavorite(movie)
        } else {
            viewModel.insertFavorite(movie)
        }
    }
}
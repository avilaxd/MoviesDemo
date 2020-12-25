package com.rudio.moviesdemo.presentation.features.movies


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.databinding.FragmentMoviesBinding
import com.rudio.moviesdemo.presentation.features.main.FragmentMainDirections
import com.rudio.moviesdemo.presentation.models.MovieUi
import com.rudio.moviesdemo.presentation.utils.ItemDecorationMovies
import com.rudio.moviesdemo.presentation.utils.API_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentMovies : Fragment() {
    private val viewModel: ViewModelMovies by viewModels()
    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.itemDecoration = ItemDecorationMovies(size = 4)
        binding.recyclerMovies.adapter = AdapterMovies(viewModel)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startObserving()
        if (viewModel.getMovies().value == null) {
            viewModel.fetchMovies(API_KEY)
        }
    }

    private fun startObserving() {
        viewModel.getEventOnClickMovie().observe(viewLifecycleOwner, { eventOnClickMovie ->
            onClick(eventOnClickMovie.getValue())
        })
    }

    private fun onClick(movie: MovieUi) {
        val action = FragmentMainDirections.actionFragmentMainToFragmentMovieDetail(movie)
        findNavController().navigate(action)
    }
}
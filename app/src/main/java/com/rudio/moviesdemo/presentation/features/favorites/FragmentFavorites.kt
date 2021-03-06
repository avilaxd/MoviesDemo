package com.rudio.moviesdemo.presentation.features.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.databinding.FragmentFavoriteBinding
import com.rudio.moviesdemo.presentation.features.main.FragmentMainDirections
import com.rudio.moviesdemo.presentation.models.MovieUi
import com.rudio.moviesdemo.presentation.utils.ItemDecorationMovies
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentFavorites : Fragment() {
    private val viewModel: ViewModelFavorites by viewModels()
    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.itemDecoration = ItemDecorationMovies(size = 4)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerFavorites.adapter = AdapterFavorites(viewModel)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startObserving()
        if (viewModel.getFavorites().value == null) {
            viewModel.fetchFavorites()
        }
    }

    private fun startObserving() {
        viewModel.getEventOnClickMovie().observe(viewLifecycleOwner, {
            onClickMovie(it.getValue())
        })
    }

    private fun onClickMovie(movie: MovieUi) {
        val action = FragmentMainDirections.actionFragmentMainToFragmentMovieDetail(movie)
        findNavController().navigate(action)
    }
}
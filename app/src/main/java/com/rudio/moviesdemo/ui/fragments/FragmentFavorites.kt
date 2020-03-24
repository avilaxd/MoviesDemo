package com.rudio.moviesdemo.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.interfaces.OnClickMovie
import com.rudio.moviesdemo.interfaces.OnDeleteMovie
import com.rudio.moviesdemo.ui.adapters.AdapterFavorites
import com.rudio.moviesdemo.ui.adapters.itemdecorators.ItemDecorationMovies
import com.rudio.moviesdemo.utils.getAppComponent
import com.rudio.moviesdemo.viewmodels.ViewModelFactory
import com.rudio.moviesdemo.viewmodels.ViewModelFavorites
import kotlinx.android.synthetic.main.fragment_favorite.*
import javax.inject.Inject

class FragmentFavorites : Fragment(R.layout.fragment_favorite), OnClickMovie, OnDeleteMovie {
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ViewModelFavorites

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getAppComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerFavorites.addItemDecoration(ItemDecorationMovies(size = 4))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelFavorites::class.java]
        startObserving(viewModel)
    }

    private fun startObserving(viewModel: ViewModelFavorites) {
        viewModel.getFavorites().observe(viewLifecycleOwner, Observer { favorites ->
            updateUI(AdapterFavorites(favorites, this, this))
        })
    }

    private fun updateUI(adapterFavorites: AdapterFavorites) {
        recyclerFavorites.adapter = adapterFavorites
    }

    override fun onClick(movie: Movie) {
        val action = FragmentMainDirections.actionFragmentMainToFragmentMovieDetail(movie)
        findNavController().navigate(action)
    }

    override fun onDelete(movie: Movie) {
        viewModel.deleteFavorite(movie)
    }
}
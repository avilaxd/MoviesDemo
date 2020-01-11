package com.rudio.moviesdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.data.repositories.RepositoryMovies
import com.rudio.moviesdemo.interfaces.OnClickMovie
import com.rudio.moviesdemo.ui.adapters.AdapterMovies
import com.rudio.moviesdemo.ui.adapters.itemdecorators.ItemDecorationMovies
import com.rudio.moviesdemo.viewmodels.ViewModelMovies
import kotlinx.android.synthetic.main.fragment_movies.*

class FragmentMovies : Fragment(), OnClickMovie {
    private lateinit var viewModel: ViewModelMovies

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerMovies.addItemDecoration(ItemDecorationMovies(size = 4))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelMovies(RepositoryMovies.getInstance())
        startObserving(viewModel)
        viewModel.fetchMovies()
    }

    private fun startObserving(viewModel: ViewModelMovies) {
        viewModel.getMovies().observe(this, Observer<List<Movie>> { movies ->
            updateUIMovies(AdapterMovies(movies, this))
        })
    }

    private fun updateUIMovies(adapterMovies: AdapterMovies) {
        recyclerMovies.adapter = adapterMovies
    }

    override fun onClick(movie: Movie) {
        val action = FragmentMoviesDirections.actionFragmentMoviesToFragmentMovieDetail(movie)
        findNavController().navigate(action)
    }
}
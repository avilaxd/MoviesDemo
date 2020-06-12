package com.rudio.moviesdemo.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.databinding.FragmentMovieDetailBinding
import com.rudio.moviesdemo.ui.adapters.AdapterBackdrops
import com.rudio.moviesdemo.ui.adapters.AdapterCast
import com.rudio.moviesdemo.ui.adapters.itemdecorators.ItemDecorationCast
import com.rudio.moviesdemo.utils.getAppComponent
import com.rudio.moviesdemo.viewmodels.ViewModelFactory
import com.rudio.moviesdemo.viewmodels.ViewModelMovieDetail
import javax.inject.Inject

class FragmentMovieDetail : Fragment() {
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var movie: Movie
    private lateinit var viewModel: ViewModelMovieDetail
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getAppComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelMovieDetail::class.java]
    }

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
        setToggleFavorite(viewModel.isFavorite(movie.id))
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startObserving()
        viewModel.fetchBackdrops(movie.id)
        viewModel.fetchCast(movie.id)
    }

    private fun startObserving() {
        viewModel.getEventOnClickFavorite().observe(viewLifecycleOwner, Observer { event ->
            setFavorite(event.getValue())
        })
    }

    private fun setToggleFavorite(isChecked: Boolean) {
        binding.toggleFavorite.isChecked = isChecked
    }

    private fun isFavoriteChecked(): Boolean {
        return binding.toggleFavorite.isChecked
    }

    private fun setFavorite(movie: Movie) {
        //It uses '!' because it first dispatches the click to the normal
        //behaviour of the toggle changing it's "isChecked" state
        if (!isFavoriteChecked()) {
            viewModel.deleteFavorite(movie)
        } else {
            viewModel.insertFavorite(movie)
        }
    }
}
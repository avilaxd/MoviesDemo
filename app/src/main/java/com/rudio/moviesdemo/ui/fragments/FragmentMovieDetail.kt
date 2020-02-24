package com.rudio.moviesdemo.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Backdrop
import com.rudio.moviesdemo.data.models.CastMember
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

class FragmentMovieDetail : Fragment() {
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var movie: Movie

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TextViewHelper.enableScroll(textSynopsisBody)
        recyclerCast.addItemDecoration(ItemDecorationCast())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelMovieDetail::class.java]
        startObserving(viewModel)
        viewModel.setMovie(movie)
        viewModel.fetchBackdrops(movie.id)
        viewModel.fetchCast(movie.id)
    }

    private fun startObserving(viewModel: ViewModelMovieDetail) {
        viewModel.getMovie().observe(viewLifecycleOwner, Observer<Movie> { movie ->
            updateUIMovie(movie)
        })
        viewModel.getBackdrops().observe(viewLifecycleOwner, Observer<List<Backdrop>> { backdrops ->
            updateUIBackdrops(AdapterBackdrops(backdrops))
        })

        viewModel.getCast().observe(viewLifecycleOwner, Observer<List<CastMember>> { cast ->
            updateUICast(AdapterCast(cast))
        })
    }

    private fun updateUIMovie(movie: Movie) {
        textTitle.text = movie.title
        textSynopsisBody.text = movie.overview
        textVotes.text = movie.votesAverage.toString()
        textDateBody.text = movie.date
        textLanguageBody.text = movie.language
        PicassoHelper.setImage(imagePoster, movie.poster?.prependPosterPath() ?: "", R.drawable.placeholder_poster)
    }

    private fun updateUIBackdrops(adapterBackdrops: AdapterBackdrops) {
        pagerImages.adapter = adapterBackdrops
    }

    private fun updateUICast(adapterCast: AdapterCast) {
        recyclerCast.adapter = adapterCast
    }
}
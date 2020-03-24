package com.rudio.moviesdemo.di.modules

import androidx.lifecycle.ViewModel
import com.rudio.moviesdemo.di.annotations.ViewModelKey
import com.rudio.moviesdemo.viewmodels.ViewModelFavorites
import com.rudio.moviesdemo.viewmodels.ViewModelMovieDetail
import com.rudio.moviesdemo.viewmodels.ViewModelMovies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ModuleViewModel {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelMovies::class)
    abstract fun bindViewModelMovies(viewModel: ViewModelMovies): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelMovieDetail::class)
    abstract fun bindViewModelMovieDetail(viewModel: ViewModelMovieDetail): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelFavorites::class)
    abstract fun bindViewModelFavorites(viewModel: ViewModelFavorites): ViewModel
}
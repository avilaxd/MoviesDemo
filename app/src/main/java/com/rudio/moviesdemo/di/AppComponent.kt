package com.rudio.moviesdemo.di

import com.rudio.moviesdemo.di.modules.ModuleNetwork
import com.rudio.moviesdemo.di.modules.ModuleViewModel
import com.rudio.moviesdemo.ui.fragments.FragmentMovieDetail
import com.rudio.moviesdemo.ui.fragments.FragmentMovies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleNetwork::class, ModuleViewModel::class])
interface AppComponent {

    fun inject(fragment: FragmentMovies)

    fun inject(fragment: FragmentMovieDetail)
}
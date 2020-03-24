package com.rudio.moviesdemo.di

import android.content.Context
import com.rudio.moviesdemo.di.modules.ModuleDatabase
import com.rudio.moviesdemo.di.modules.ModuleNetwork
import com.rudio.moviesdemo.di.modules.ModuleViewModel
import com.rudio.moviesdemo.ui.fragments.FragmentFavorites
import com.rudio.moviesdemo.ui.fragments.FragmentMovieDetail
import com.rudio.moviesdemo.ui.fragments.FragmentMovies
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleNetwork::class, ModuleViewModel::class, ModuleDatabase::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: FragmentMovies)

    fun inject(fragment: FragmentMovieDetail)

    fun inject(fragment: FragmentFavorites)
}
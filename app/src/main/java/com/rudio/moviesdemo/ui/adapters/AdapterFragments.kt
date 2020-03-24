package com.rudio.moviesdemo.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rudio.moviesdemo.ui.fragments.FragmentFavorites
import com.rudio.moviesdemo.ui.fragments.FragmentMovies

class AdapterFragments(
    fragmentManager: FragmentManager, lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FragmentMovies()
            1 -> FragmentFavorites()
            else -> FragmentMovies()
        }
    }
}
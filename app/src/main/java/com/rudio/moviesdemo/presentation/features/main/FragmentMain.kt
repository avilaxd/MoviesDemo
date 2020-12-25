package com.rudio.moviesdemo.presentation.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.databinding.FragmentMainBinding

class FragmentMain : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.pagerMain.adapter =
            AdapterFragments(
                requireActivity().supportFragmentManager,
                lifecycle
            )
        binding.titles = listOf(getString(R.string.tab_movies), getString(R.string.tab_favorites))
        return binding.root
    }
}
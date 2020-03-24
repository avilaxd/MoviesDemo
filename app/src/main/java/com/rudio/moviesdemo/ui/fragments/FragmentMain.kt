package com.rudio.moviesdemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.ui.adapters.AdapterFragments
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentMain : Fragment(R.layout.fragment_main) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUI()
    }

    private fun setUI() {
        val titles = listOf(getString(R.string.tab_movies), getString(R.string.tab_favorites))
        pagerMain.adapter = AdapterFragments(requireActivity().supportFragmentManager, lifecycle)
        TabLayoutMediator(tabMain, pagerMain) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}
package com.rudio.moviesdemo.ui

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.rudio.moviesdemo.data.models.Backdrop
import com.rudio.moviesdemo.data.models.CastMember
import com.rudio.moviesdemo.data.models.Movie
import com.rudio.moviesdemo.ui.adapters.AdapterBackdrops
import com.rudio.moviesdemo.ui.adapters.AdapterCast
import com.rudio.moviesdemo.ui.adapters.AdapterFavorites
import com.rudio.moviesdemo.ui.adapters.AdapterMovies
import com.rudio.moviesdemo.utils.PicassoHelper
import com.rudio.moviesdemo.utils.TextViewHelper

@BindingAdapter("android:text")
fun setText(textView: TextView, value: Double) {
    textView.text = value.toString()
}

@BindingAdapter("app:itemDecoration")
fun setItemDecoration(recyclerView: RecyclerView, itemDecoration: RecyclerView.ItemDecoration) {
    recyclerView.addItemDecoration(itemDecoration)
}

@BindingAdapter("app:nestedScrolling")
fun setNestedScrolling(textView: TextView, enabled: Boolean) {
    if (enabled) TextViewHelper.enableScroll(textView)
    else TextViewHelper.disableScroll(textView)
}

@BindingAdapter(value = ["app:url", "app:placeholder"], requireAll = true)
fun loadImage(imageView: ImageView, url: String?, placeholder: Drawable) {
    PicassoHelper.setImage(imageView, url, placeholder)
}

@BindingAdapter("app:cast")
fun setCast(recyclerView: RecyclerView, cast: List<CastMember>?) {
    val adapter = recyclerView.adapter
    if (cast != null && adapter is AdapterCast) {
        adapter.setCast(cast)
    }
}

@BindingAdapter("app:backdrops")
fun setBackdrops(viewPager: ViewPager2, backdrops: List<Backdrop>?) {
    val adapter = viewPager.adapter
    if (backdrops != null && adapter is AdapterBackdrops) {
        adapter.setBackdrops(backdrops)
    }
}

@BindingAdapter("app:movies")
fun setMovies(recyclerView: RecyclerView, movies: List<Movie>?) {
    val adapter = recyclerView.adapter
    if (movies != null && adapter is AdapterMovies) {
        adapter.setMovies(movies)
    }
}

@BindingAdapter("app:favorites")
fun setFavorites(recyclerView: RecyclerView, favorites: List<Movie>?) {
    val adapter = recyclerView.adapter
    if (favorites != null && adapter is AdapterFavorites) {
        adapter.setFavorites(favorites)
    }
}

@BindingAdapter(value = ["app:titles", "app:pager"], requireAll = true)
fun setPager(tabLayout: TabLayout, titles: List<String>, pager: ViewPager2) {
    TabLayoutMediator(tabLayout, pager) { tab, position ->
        tab.text = titles[position]
    }.attach()
}
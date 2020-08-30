package com.rudio.moviesdemo.presentation.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.rudio.moviesdemo.domain.models.IBackdrop
import com.rudio.moviesdemo.domain.models.ICastMember
import com.rudio.moviesdemo.domain.models.IMovie
import com.rudio.moviesdemo.presentation.features.moviedetail.AdapterBackdrops
import com.rudio.moviesdemo.presentation.features.moviedetail.AdapterCast
import com.rudio.moviesdemo.presentation.features.favorites.AdapterFavorites
import com.rudio.moviesdemo.presentation.features.movies.AdapterMovies

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
fun setCast(recyclerView: RecyclerView, cast: List<ICastMember>?) {
    val adapter = recyclerView.adapter
    if (cast != null && adapter is AdapterCast) {
        adapter.setCast(cast)
    }
}

@BindingAdapter("app:backdrops")
fun setBackdrops(viewPager: ViewPager2, backdrops: List<IBackdrop>?) {
    val adapter = viewPager.adapter
    if (backdrops != null && adapter is AdapterBackdrops) {
        adapter.setBackdrops(backdrops)
    }
}

@BindingAdapter("app:movies")
fun setMovies(recyclerView: RecyclerView, movies: List<IMovie>?) {
    val adapter = recyclerView.adapter
    if (movies != null && adapter is AdapterMovies) {
        adapter.setMovies(movies)
    }
}

@BindingAdapter("app:favorites")
fun setFavorites(recyclerView: RecyclerView, favorites: List<IMovie>?) {
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
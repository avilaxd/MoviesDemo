package com.rudio.moviesdemo.utils

import androidx.fragment.app.Fragment
import com.rudio.moviesdemo.di.AppComponent
import com.rudio.moviesdemo.ui.AppMain
import com.rudio.moviesdemo.ui.MainActivity

fun String.prependPosterPath(): String {
    return BASE_URL_POSTER + this
}

fun String.prependBackdropPath(): String {
    return BASE_URL_BACKDROP + this
}

fun String.prependCastPath(): String {
    return BASE_URL_CAST + this
}

fun MainActivity.getAppComponent(): AppComponent {
    return (this.application as AppMain).appComponent
}

fun Fragment.getAppComponent(): AppComponent {
    return (activity as MainActivity).getAppComponent()
}
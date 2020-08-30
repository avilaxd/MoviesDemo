package com.rudio.moviesdemo.presentation.utils

fun String.prependPosterPath(): String {
    return BASE_URL_POSTER + this
}

fun String.prependBackdropPath(): String {
    return BASE_URL_BACKDROP + this
}

fun String.prependCastPath(): String {
    return BASE_URL_CAST + this
}
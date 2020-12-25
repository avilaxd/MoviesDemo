package com.rudio.moviesdemo.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BackdropUi(
    val width: Int = 0,
    val height: Int = 0,
    val path: String = ""
) : Parcelable
package com.rudio.moviesdemo.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Backdrop(
    val width: Int,
    val height: Int,
    @SerializedName("file_path")
    val path: String? = null
) : Parcelable
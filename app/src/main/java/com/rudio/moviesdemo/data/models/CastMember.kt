package com.rudio.moviesdemo.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CastMember(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val nameActor: String = "",
    @SerializedName("character")
    val nameCharacter: String = "",
    @SerializedName("profile_path")
    val picture: String? = null
) : Parcelable
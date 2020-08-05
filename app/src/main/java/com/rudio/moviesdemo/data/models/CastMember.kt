package com.rudio.moviesdemo.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class CastMember(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val nameActor: String = "",
    @Json(name = "character")
    val nameCharacter: String = "",
    @Json(name = "profile_path")
    val picture: String = ""
) : Parcelable
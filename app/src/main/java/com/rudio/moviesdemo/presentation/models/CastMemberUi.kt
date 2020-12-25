package com.rudio.moviesdemo.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CastMemberUi(
    val id: Int = 0,
    val nameActor: String = "",
    val nameCharacter: String = "",
    val picture: String = ""
) :  Parcelable
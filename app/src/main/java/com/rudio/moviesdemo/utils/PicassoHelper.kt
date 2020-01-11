package com.rudio.moviesdemo.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

class PicassoHelper {

    companion object {

        fun setImage(imageView: ImageView, path: String, drawableId: Int) {
            if (path.isNotEmpty()) {
                Picasso.get().load(path).placeholder(drawableId).into(imageView)
            } else {
                Picasso.get().load(drawableId).into(imageView)
            }
        }
    }
}
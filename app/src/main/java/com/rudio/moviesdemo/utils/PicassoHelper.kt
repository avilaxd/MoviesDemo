package com.rudio.moviesdemo.utils

import android.graphics.drawable.Drawable
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

        fun setImage(imageView: ImageView, url: String?, drawable: Drawable) {
            if (url != null && url.isNotEmpty()) {
                Picasso.get().load(url).placeholder(drawable).into(imageView)
            } else {
                imageView.setImageDrawable(drawable)
            }
        }
    }
}
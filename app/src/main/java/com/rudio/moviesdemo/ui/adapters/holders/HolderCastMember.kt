package com.rudio.moviesdemo.ui.adapters.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.CastMember
import com.rudio.moviesdemo.utils.PicassoHelper
import com.rudio.moviesdemo.utils.prependCastPath
import kotlinx.android.synthetic.main.holder_castmember.view.*

class HolderCastMember(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(castMember: CastMember) {
        itemView.textNameActor.text = castMember.nameActor
        itemView.textNameCharacter.text = castMember.nameCharacter
        PicassoHelper.setImage(
            itemView.imagePicture,
            castMember.picture?.prependCastPath() ?: "",
            R.drawable.placeholder_poster)
    }
}
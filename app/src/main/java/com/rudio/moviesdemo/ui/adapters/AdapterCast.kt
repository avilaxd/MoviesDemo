package com.rudio.moviesdemo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.CastMember
import com.rudio.moviesdemo.ui.adapters.holders.HolderCastMember

class AdapterCast(private val cast: List<CastMember>) : RecyclerView.Adapter<HolderCastMember>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCastMember {
        return HolderCastMember(LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_castmember, parent, false))
    }

    override fun getItemCount(): Int {
        return cast.size
    }

    override fun onBindViewHolder(holder: HolderCastMember, position: Int) {
        holder.onBind(cast[position])
    }
}
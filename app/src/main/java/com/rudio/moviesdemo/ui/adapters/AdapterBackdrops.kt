package com.rudio.moviesdemo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.R
import com.rudio.moviesdemo.data.models.Backdrop
import com.rudio.moviesdemo.ui.adapters.holders.HolderBackdrop

class AdapterBackdrops(
    private val backdrops: List<Backdrop>
) : RecyclerView.Adapter<HolderBackdrop>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderBackdrop {
        return HolderBackdrop(LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_backdrop, parent, false))
    }

    override fun getItemCount(): Int {
        return backdrops.size
    }

    override fun onBindViewHolder(holder: HolderBackdrop, position: Int) {
        holder.onBind(backdrops[position])
    }
}
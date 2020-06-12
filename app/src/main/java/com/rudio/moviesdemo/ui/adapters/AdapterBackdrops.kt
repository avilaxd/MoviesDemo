package com.rudio.moviesdemo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.data.models.Backdrop
import com.rudio.moviesdemo.databinding.HolderBackdropBinding
import com.rudio.moviesdemo.ui.adapters.holders.HolderBackdrop

class AdapterBackdrops(
    private var backdrops: List<Backdrop> = listOf()
) : RecyclerView.Adapter<HolderBackdrop>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderBackdrop {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderBackdropBinding.inflate(layoutInflater, parent, false)
        return HolderBackdrop(binding)
    }

    fun setBackdrops(backdrops: List<Backdrop>) {
        this.backdrops = backdrops
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return backdrops.size
    }

    override fun onBindViewHolder(holder: HolderBackdrop, position: Int) {
        holder.onBind(backdrops[position])
    }
}
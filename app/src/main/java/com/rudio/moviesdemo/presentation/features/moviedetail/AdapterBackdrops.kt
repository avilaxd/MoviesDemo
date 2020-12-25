package com.rudio.moviesdemo.presentation.features.moviedetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderBackdropBinding
import com.rudio.moviesdemo.presentation.models.BackdropUi

class AdapterBackdrops(
    private var backdrops: List<BackdropUi> = listOf()
) : RecyclerView.Adapter<HolderBackdrop>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderBackdrop {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderBackdropBinding.inflate(layoutInflater, parent, false)
        return HolderBackdrop(
            binding
        )
    }

    fun setBackdrops(backdrops: List<BackdropUi>) {
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
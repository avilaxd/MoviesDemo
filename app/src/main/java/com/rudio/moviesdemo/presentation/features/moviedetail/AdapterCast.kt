package com.rudio.moviesdemo.presentation.features.moviedetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudio.moviesdemo.databinding.HolderCastmemberBinding
import com.rudio.moviesdemo.presentation.models.CastMemberUi

class AdapterCast(
    private var cast: List<CastMemberUi> = listOf()
) : RecyclerView.Adapter<HolderCastMember>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCastMember {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderCastmemberBinding.inflate(layoutInflater, parent, false)
        return HolderCastMember(
            binding
        )
    }

    fun setCast(cast: List<CastMemberUi>) {
        this.cast = cast
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cast.size
    }

    override fun onBindViewHolder(holder: HolderCastMember, position: Int) {
        holder.onBind(cast[position])
    }
}
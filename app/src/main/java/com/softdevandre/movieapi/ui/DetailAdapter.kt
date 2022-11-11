package com.softdevandre.movieapi.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softdevandre.movieapi.databinding.DetailItemBinding
import com.softdevandre.movieapi.model.Cast
import com.softdevandre.movieapi.ui.MovieListAdapter.Companion.IMAGE_BASE

class DetailAdapter(private val context: Context, private val dataset: List<Cast>) :
    RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    class DetailViewHolder(private val binding: DetailItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            val castName: TextView = binding.tvCastName
            val castCharacter: TextView = binding.tvCastCharacter
            val castPicture: ImageView = binding.ivCast
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            DetailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = dataset[position]
        Glide.with(holder.itemView.context)
            .load(IMAGE_BASE + item.picture)
            .into(holder.castPicture)
        holder.castName.text = item.name
        holder.castCharacter.text = item.character
    }

    override fun getItemCount() = dataset.size
}
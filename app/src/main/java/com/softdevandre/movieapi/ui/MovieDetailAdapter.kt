package com.softdevandre.movieapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.softdevandre.movieapi.databinding.MovieDetailItemBinding
import com.softdevandre.movieapi.network.Cast

class MovieDetailAdapter :
    ListAdapter<Cast, MovieDetailAdapter.CastViewHolder>(CastDiffCallback) {
    class CastViewHolder(private var binding: MovieDetailItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cast: Cast) {
            binding.cast = cast
            binding.executePendingBindings()
        }
    }

    companion object CastDiffCallback : DiffUtil.ItemCallback<Cast>() {
        override fun areItemsTheSame(oldItem: Cast, newItem: Cast): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cast, newItem: Cast): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        return CastViewHolder(
            MovieDetailItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val cast = getItem(position)
        holder.bind(cast)
    }
}



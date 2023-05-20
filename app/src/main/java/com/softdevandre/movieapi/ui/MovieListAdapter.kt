package com.softdevandre.movieapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.softdevandre.movieapi.databinding.MovieListItemBinding
import com.softdevandre.movieapi.network.Movie

class MovieListAdapter(private val clickListener: MovieListener) :
    ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(DiffCallback) {

    class MovieViewHolder(private var binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: MovieListener, movie: Movie) {
            binding.movie = movie
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(clickListener, movie)
    }

}

class MovieListener(val clickListener: (movie: Movie) -> Unit) {
    fun onClick(movie: Movie) = clickListener(movie)
}
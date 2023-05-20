package com.softdevandre.movieapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.softdevandre.movieapi.R
import com.softdevandre.movieapi.databinding.FragmentMovieListBinding

class MovieListFragment : Fragment() {

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMovieListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.rvMovieList.adapter = MovieListAdapter(MovieListener { movie ->
            viewModel.onMovieClicked(movie)
            findNavController().navigate(R.id.action_movieListFragment_to_movieDetailFragment)
        })
        return binding.root
    }
}
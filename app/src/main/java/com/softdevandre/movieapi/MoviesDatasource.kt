package com.softdevandre.movieapi

class MoviesDatasource {
    fun loadMovies(): List<Movies>{
        return listOf(
            Movies(R.string.gladiator, R.string.gladiator_year, R.drawable.gladiator),
            Movies(R.string.matrix_revolutions, R.string.matrix_revolutions_year, R.drawable.matrix),
            Movies(R.string.v_for_vendetta, R.string.v_for_vendetta_year, R.drawable.vforvendetta),
            Movies(R.string.interstellar, R.string.interstellar_year, R.drawable.interstellar)
        ).toList()
    }
}
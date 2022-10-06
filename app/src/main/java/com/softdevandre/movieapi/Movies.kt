package com.softdevandre.movieapi

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Movies(
    @StringRes val movieName: Int,
    @StringRes val movieYear: Int,
    @DrawableRes val movieImage: Int
)

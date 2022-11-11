package com.softdevandre.movieapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CastResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("cast")
    val cast: List<Cast>
) : Parcelable {
    constructor() : this("", mutableListOf())
}
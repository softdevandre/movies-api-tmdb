package com.softdevandre.movieapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cast(
    @SerializedName("id")
    val id: String?,

    @SerializedName("cast_id")
    val castId: String?,

    @SerializedName("credit_id")
    val creditId: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("profile_path")
    val picture: String?,

    @SerializedName("character")
    val character: String?
) : Parcelable {
    constructor() : this("", "", "", "", "", "")
}
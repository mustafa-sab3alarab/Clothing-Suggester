package com.example.clothingsuggester.model.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class Coord(
    @SerializedName("lon") val lon: String?,
    @SerializedName("lat") val lat: String?
) : Parcelable
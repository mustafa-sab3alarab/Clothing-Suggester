package com.example.clothingsuggester.model.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class Wind(
    @SerializedName("speed") val speed : String?,
    @SerializedName("deg") val deg : String?,
    @SerializedName("gust") val gust : String?
) : Parcelable
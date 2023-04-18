package com.example.clothingsuggester.model.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class WeatherMap(
    @SerializedName("coord") val coord: Coord?,
    @SerializedName("weather") val weather: ArrayList<Weather>?,
    @SerializedName("base") val base: String?,
    @SerializedName("main") val main: Main?,
    @SerializedName("wind") val wind: Wind?,
    @SerializedName("rain") val rain: Rain?,
    @SerializedName("sys") val sys: Sys?,
    @SerializedName("name") val name: String?,
    @SerializedName("cod") val cod: String?
) : Parcelable

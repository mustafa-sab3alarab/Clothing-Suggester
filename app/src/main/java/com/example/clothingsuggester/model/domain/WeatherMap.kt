package com.example.clothingsuggester.model.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class WeatherMap(
    @SerializedName("coord") val coord: Coord?,
    @SerializedName("weather") val weather: ArrayList<Weather>?,
    @SerializedName("base") val base: String?,
    @SerializedName("main") val main: Main?,
    @SerializedName("visibility") val visibility: String?,
    @SerializedName("wind") val wind: Wind?,
    @SerializedName("rain") val rain: Rain?,
    @SerializedName("clouds") val clouds: Clouds?,
    @SerializedName("dt") val dt: String?,
    @SerializedName("sys") val sys: Sys?,
    @SerializedName("timezone") val timezone: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("cod") val cod: String?
) : Parcelable

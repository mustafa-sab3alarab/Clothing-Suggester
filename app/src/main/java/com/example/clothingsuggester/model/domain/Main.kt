package com.example.clothingsuggester.model.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class Main(
    @SerializedName("temp") val temp: String?,
    @SerializedName("feels_like") val feels_like: String?,
    @SerializedName("temp_min") val temp_min: String?,
    @SerializedName("temp_max") val temp_max: String?,
    @SerializedName("pressure") val pressure: String?,
    @SerializedName("humidity") val humidity: String?
): Parcelable

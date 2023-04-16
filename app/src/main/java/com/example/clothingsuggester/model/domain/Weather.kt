package com.example.clothingsuggester.model.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class Weather(
    @SerializedName("id") val id : String?,
    @SerializedName("main") val main : String?,
    @SerializedName("description") val description : String?,
    @SerializedName("icon") val icon : String?
): Parcelable

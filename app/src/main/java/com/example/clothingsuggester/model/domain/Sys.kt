package com.example.clothingsuggester.model.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class Sys(
    @SerializedName("type") val type : String?,
    @SerializedName("id") val id : String?,
    @SerializedName("country") val country : String?,
    @SerializedName("sunrise") val sunrise : String?,
    @SerializedName("sunset") val sunset : String?
): Parcelable

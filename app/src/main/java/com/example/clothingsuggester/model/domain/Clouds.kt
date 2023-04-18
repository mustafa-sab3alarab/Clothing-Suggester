package com.example.clothingsuggester.model.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class Clouds(
    @SerializedName("all") val all: String?
) : Parcelable

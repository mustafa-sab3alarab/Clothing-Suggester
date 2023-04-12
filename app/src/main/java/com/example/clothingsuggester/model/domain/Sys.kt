package com.example.clothingsuggester.model.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("type") val type : String?,
    @SerializedName("id") val id : String?,
    @SerializedName("country") val country : String?,
    @SerializedName("sunrise") val sunrise : String?,
    @SerializedName("sunset") val sunset : String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(id)
        parcel.writeString(country)
        parcel.writeString(sunrise)
        parcel.writeString(sunset)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sys> {
        override fun createFromParcel(parcel: Parcel): Sys {
            return Sys(parcel)
        }

        override fun newArray(size: Int): Array<Sys?> {
            return arrayOfNulls(size)
        }
    }
}

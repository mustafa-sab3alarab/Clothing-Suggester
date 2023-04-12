package com.example.clothingsuggester.model.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("speed") val speed : String?,
    @SerializedName("deg") val deg : String?,
    @SerializedName("gust") val gust : String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(speed)
        parcel.writeString(deg)
        parcel.writeString(gust)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Wind> {
        override fun createFromParcel(parcel: Parcel): Wind {
            return Wind(parcel)
        }

        override fun newArray(size: Int): Array<Wind?> {
            return arrayOfNulls(size)
        }
    }
}
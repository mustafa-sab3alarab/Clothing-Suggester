package com.example.clothingsuggester.model.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp") val temp: String?,
    @SerializedName("feels_like") val feels_like: String?,
    @SerializedName("temp_min") val temp_min: String?,
    @SerializedName("temp_max") val temp_max: String?,
    @SerializedName("pressure") val pressure: String?,
    @SerializedName("humidity") val humidity: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(temp)
        dest.writeString(feels_like)
        dest.writeString(temp_min)
        dest.writeString(temp_max)
        dest.writeString(pressure)
        dest.writeString(humidity)
    }

    companion object CREATOR : Parcelable.Creator<Main> {
        override fun createFromParcel(parcel: Parcel): Main {
            return Main(parcel)
        }

        override fun newArray(size: Int): Array<Main?> {
            return arrayOfNulls(size)
        }
    }
}

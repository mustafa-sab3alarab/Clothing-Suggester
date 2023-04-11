package com.example.clothingsuggester.model.domain

import android.os.Parcel
import android.os.Parcelable

data class Main(
    val temp: String?,
    val feels_like: String?,
    val temp_min: String?,
    val temp_max: String?,
    val pressure: String?,
    val humidity: String?,
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

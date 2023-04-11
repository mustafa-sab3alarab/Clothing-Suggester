package com.example.clothingsuggester.model.domain

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

data class WeatherMap(
    val coord: Coord?,
    val weather: ArrayList<Weather>?,
    val base: String?,
    val main: Main?,
    val visibility: String?,
    val wind: Wind?,
    val rain: Rain?,
    val clouds: Clouds?,
    val dt: String?,
    val sys: Sys?,
    val timezone: String?,
    val id: String?,
    val name: String?,
    val cod: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Coord::class.java.classLoader),
        parcel.createTypedArrayList(Weather.CREATOR),
        parcel.readString(),
        parcel.readParcelable(Main::class.java.classLoader),
        parcel.readString(),
        parcel.readParcelable(Wind::class.java.classLoader),
        parcel.readParcelable(Rain::class.java.classLoader),
        parcel.readParcelable(Clouds::class.java.classLoader),
        parcel.readString(),
        parcel.readParcelable(Sys::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(coord, flags)
        parcel.writeString(base)
        parcel.writeParcelable(main, flags)
        parcel.writeString(visibility)
        parcel.writeParcelable(wind, flags)
        parcel.writeParcelable(rain, flags)
        parcel.writeParcelable(clouds, flags)
        parcel.writeString(dt)
        parcel.writeParcelable(sys, flags)
        parcel.writeString(timezone)
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(cod)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherMap> {
        override fun createFromParcel(parcel: Parcel): WeatherMap {
            return WeatherMap(parcel)
        }

        override fun newArray(size: Int): Array<WeatherMap?> {
            return arrayOfNulls(size)
        }
    }

}

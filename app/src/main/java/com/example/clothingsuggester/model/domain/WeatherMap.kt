package com.example.clothingsuggester.model.domain

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

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

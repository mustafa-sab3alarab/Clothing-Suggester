package com.example.clothingsuggester.model.network

import com.example.clothingsuggester.BuildConfig
import com.google.android.gms.maps.model.LatLng
import okhttp3.Call
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

class Client {

    private val okHttpClient = OkHttpClient()

    fun makeRequest(latLng: LatLng): Call {
        val request = Request.Builder().url(httpUrl(latLng)).build()
        return okHttpClient.newCall(request)
    }

    private fun httpUrl(latLng: LatLng): HttpUrl {
        return HttpUrl.Builder()
            .scheme(SCHEME)
            .host(BuildConfig.HOST)
            .addPathSegment(DATA)
            .addPathSegment(VERSION)
            .addPathSegment(WEATHER)
            .addQueryParameter(LAT, latLng.latitude.toString())
            .addQueryParameter(LON, latLng.longitude.toString())
            .addQueryParameter(API_ID, BuildConfig.API_KEY)
            .build()
    }

    private companion object {
        const val SCHEME = "https"
        const val DATA = "data"
        const val VERSION = "2.5"
        const val WEATHER = "weather"
        const val LAT = "lat"
        const val LON = "lon"
        const val API_ID = "appid"
    }

}
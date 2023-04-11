package com.example.clothingsuggester.model


import com.google.android.gms.maps.model.LatLng
import okhttp3.Call

interface ApiService {

    fun getWeatherMap(latLng: LatLng) : Call
}
package com.example.clothingsuggester.model

import com.example.clothingsuggester.model.network.Client
import com.google.android.gms.maps.model.LatLng
import okhttp3.Call

class ApiServiceImp : ApiService{

    private val client = Client()

    override fun getWeatherMap(latLng: LatLng): Call {
        return client.makeRequest(latLng)
    }
}
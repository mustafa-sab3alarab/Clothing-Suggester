package com.example.clothingsuggester.model

import com.example.clothingsuggester.model.domain.WeatherMap
import com.example.clothingsuggester.model.network.Client
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class ApiServiceImp : ApiService {

    private val client = Client()

    override fun getWeatherMap(
        latLng: LatLng,
        onSuccess: (response: WeatherMap) -> Unit,
        onFailure: (message: String?) -> Unit
    ) {
        client.makeRequest(latLng).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onFailure(e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val gson = Gson()
                val weatherMap = gson.fromJson(response.body?.string(), WeatherMap::class.java)
                onSuccess(weatherMap)
            }

        })
    }
}
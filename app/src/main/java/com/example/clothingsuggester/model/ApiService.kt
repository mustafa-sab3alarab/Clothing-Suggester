package com.example.clothingsuggester.model


import com.example.clothingsuggester.model.domain.WeatherMap
import com.google.android.gms.maps.model.LatLng

interface ApiService {

    fun getWeatherMap(
        latLng: LatLng,
        onSuccess: (response: WeatherMap) -> Unit,
        onFailure: (message: String?) -> Unit
    )

}
package com.example.clothingsuggester.presenter

import com.example.clothingsuggester.model.ApiServiceImp
import com.example.clothingsuggester.ui.splash.ISplashView
import com.google.android.gms.maps.model.LatLng
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class SplashPresenter(val splashView: ISplashView) {

    private val apiService = ApiServiceImp()

    fun getCurrentWeatherMap(
        latLng: LatLng,
        onResponse: (call: Call, response: Response) -> Unit,
        onFailure: (call: Call, e: IOException) -> Unit
    ) {
        apiService.getWeatherMap(latLng).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onFailure(call, e)
            }

            override fun onResponse(call: Call, response: Response) {
                onResponse(call, response)
            }
        })
    }
}
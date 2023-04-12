package com.example.clothingsuggester.ui.splash

import android.util.Log
import com.example.clothingsuggester.model.ApiServiceImp
import com.example.clothingsuggester.model.domain.WeatherMap
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class SplashPresenter(private val splashView: ISplashView) {

    private val apiService = ApiServiceImp()
    private val LOG_TAG = this::class.java.simpleName

    private companion object {
        const val STATUS_CODE_OK = 200
    }

    fun getCurrentWeatherMap(latLng: LatLng) {

        apiService.getWeatherMap(latLng).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.v(LOG_TAG, e.message.toString())
                splashView.onFailureWeather(e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.code == STATUS_CODE_OK) {
                    val gson = Gson()
                    val weatherMap = gson.fromJson(response.body?.string(), WeatherMap::class.java)
                    Log.v(LOG_TAG, weatherMap.toString())
                    splashView.onSuccessWeather(weatherMap)
                }
            }
        })
    }
}
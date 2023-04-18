package com.example.clothingsuggester.ui.splash

import com.example.clothingsuggester.model.ApiServiceImp
import com.example.clothingsuggester.model.domain.WeatherMap
import com.google.android.gms.maps.model.LatLng

class SplashPresenter(private val splashView: ISplashView) {

    private val apiService = ApiServiceImp()

    fun getCurrentWeatherMap(latLng: LatLng) {
        apiService.getWeatherMap(latLng, ::onSuccess, ::onFailure)
    }

    private fun onSuccess(weatherMap: WeatherMap) {
        splashView.navigateToHome(weatherMap)
    }

    private fun onFailure(message: String?) {
        splashView.showSnackbarError(message.toString())
    }
}
package com.example.clothingsuggester.ui.splash

import com.example.clothingsuggester.model.domain.WeatherMap

interface ISplashView {
    fun onSuccessWeather(weatherMap : WeatherMap)
    fun onFailureWeather(error : String)
}
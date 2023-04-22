package com.example.clothingsuggester.ui.splash

import com.example.clothingsuggester.model.domain.WeatherMap

interface ISplashView {
    fun navigateToHome(weatherMap : WeatherMap)
    fun showSnackbarError(error : String)
}
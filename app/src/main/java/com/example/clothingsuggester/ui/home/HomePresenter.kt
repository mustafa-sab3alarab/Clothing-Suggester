package com.example.clothingsuggester.ui.home

import com.example.clothingsuggester.model.db.DataBase

class HomePresenter(private val homeView: IHomeView) {

    private val db = DataBase()
    fun getCurrentWeatherIconUrl(iconId: String?) {
        val imageUrl = db.getAllWeatherIcons()[iconId].toString()
        homeView.setWeatherImage(imageUrl)
    }

}
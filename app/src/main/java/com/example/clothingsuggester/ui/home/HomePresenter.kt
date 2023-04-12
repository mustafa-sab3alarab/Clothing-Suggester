package com.example.clothingsuggester.ui.home

import com.example.clothingsuggester.model.db.DataBase

class HomePresenter(private val homeView: IHomeView) {

    private val db = DataBase()
    fun getCurrentWeatherIconUrl(iconId: String?): String {
        return db.getAllWeatherIcons()[iconId].toString()
    }

}
package com.example.clothingsuggester.presenter

import com.example.clothingsuggester.model.ApiServiceImp
import com.example.clothingsuggester.ui.home.IHomeView

class HomePresenter(val homeView : IHomeView) {

    private val apiService = ApiServiceImp()

}
package com.example.clothingsuggester.util

import android.content.Context
import android.content.SharedPreferences


object SharedPreferences {

    private lateinit var sharedPreferences: SharedPreferences

    private const val SHARED_PREF = "clothes_prefs"
    private const val LATEST_CLOTHE = "latest_clothe"
    private const val DATE = "date"

    fun initPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
    }

    var latestClothe: String?
        get() = sharedPreferences.getString(LATEST_CLOTHE, null)
        set(value) {
            sharedPreferences.edit().putString(LATEST_CLOTHE, value).apply()
        }
}
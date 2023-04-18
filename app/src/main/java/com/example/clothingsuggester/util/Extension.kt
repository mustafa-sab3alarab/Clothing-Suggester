package com.example.clothingsuggester.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.Calendar

fun String.toCelsius(): String {
    return "${(this.toDouble() - 273.15).toInt()}"
}

fun String.toKmPerHour(): String {
    return "${(this.toDouble() * 3.6).toInt()}"
}

fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url).centerCrop().into(this)
}

fun getCurrentDay(): String {
    val calendar = Calendar.getInstance()
    return calendar.get(Calendar.DAY_OF_MONTH).toString()
}

fun getNextDay(): String {
    val calendar = Calendar.getInstance()
    return calendar.add(Calendar.DAY_OF_YEAR, 1).toString()
}
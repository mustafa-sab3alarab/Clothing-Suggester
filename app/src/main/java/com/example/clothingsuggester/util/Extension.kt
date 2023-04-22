package com.example.clothingsuggester.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun String.toCelsius(): String {
    return "${(this.toDouble() - 273.15).toInt()}"
}

fun String.toKmPerHour(): String {
    return "${(this.toDouble() * 3.6).toInt()}"
}

fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url).centerCrop().into(this)
}
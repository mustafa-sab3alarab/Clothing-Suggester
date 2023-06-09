package com.example.clothingsuggester.ui.home

import com.example.clothingsuggester.R
import com.example.clothingsuggester.model.domain.Clothe
import com.example.clothingsuggester.util.SharedPreferences

class WearSuggestion {

    private companion object {
        val FREEZING = Int.MIN_VALUE..0
        val COOL = 1..18
        val MILD = 19..25
        val WARM = 26..35
        val VERY_HOT = 36..Int.MAX_VALUE
    }

    private val clothes = mapOf(
        FREEZING to listOf(
            Clothe(R.drawable.image_freezing_01),
            Clothe(R.drawable.image_freezing_02)
        ),
        COOL to listOf(
            Clothe(R.drawable.image_cool_01),
            Clothe(R.drawable.image_cool_02),
        ),
        MILD to listOf(
            Clothe(R.drawable.image_mild_01),
            Clothe(R.drawable.image_mild_02)
        ),
        WARM to listOf(
            Clothe(R.drawable.image_warm_01),
            Clothe(R.drawable.image_warm_02)
        ),
        VERY_HOT to listOf(
            Clothe(R.drawable.image_hot_01),
            Clothe(R.drawable.image_hot_02)
        )
    )

    fun suggestWearForToday(temp: String?): Int? {

        val temperature = when (temp?.toInt()) {
            in Int.MIN_VALUE..0 -> FREEZING
            in 1..18 -> COOL
            in 19..25 -> MILD
            in 26..35 -> WARM
            else -> VERY_HOT
        }

        val clothesByTemperature: List<Clothe>? = clothes[temperature]

        val latestWear = SharedPreferences.latestClothe

        return if (latestWear.isNullOrEmpty()) {
            val newClothe = clothesByTemperature?.random()?.imageId
            SharedPreferences.latestClothe = newClothe.toString()
            newClothe
        } else {
            val unWorn = clothesByTemperature?.find {
                it.imageId != latestWear.toIntOrNull()
            }?.imageId
            SharedPreferences.latestClothe = unWorn.toString()
            unWorn
        }
    }
}
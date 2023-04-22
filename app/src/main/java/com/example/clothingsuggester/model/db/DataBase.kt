package com.example.clothingsuggester.model.db

import com.example.clothingsuggester.util.WeatherIconsConstants

class DataBase {

    fun getAllWeatherIcons(): Map<String, String> {
        return mapOf(
            WeatherIconsConstants.CLEAR_SKY_DAY.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/01d.png",
            WeatherIconsConstants.CLEAR_SKY_NIGHT.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/01n.png",
            WeatherIconsConstants.FEW_CLOUDS_DAY.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/02d.png",
            WeatherIconsConstants.FEW_CLOUDS_NIGHT.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/02n.png",
            WeatherIconsConstants.SCATTERED_CLOUDS_DAY.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/03d.png",
            WeatherIconsConstants.SCATTERED_CLOUDS_NIGHT.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/03n.png",
            WeatherIconsConstants.BROKEN_CLOUDS_DAY.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/04d.png",
            WeatherIconsConstants.BROKEN_CLOUDS_NIGHT.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/04n.png",
            WeatherIconsConstants.SHOWER_RAIN_DAY.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/09d.png",
            WeatherIconsConstants.SHOWER_RAIN_NIGHT.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/09n.png",
            WeatherIconsConstants.RAIN_DAY.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/10d.png",
            WeatherIconsConstants.RAIN_NIGHT.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/10n.png",
            WeatherIconsConstants.THUNDERSTORM_DAY.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/11d.png",
            WeatherIconsConstants.THUNDERSTORM_NIGHT.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/11n.png",
            WeatherIconsConstants.SNOW_DAY.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/13d.png",
            WeatherIconsConstants.SNOW_NIGHT.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/13d.png",
            WeatherIconsConstants.MIST_DAY.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/50d.png",
            WeatherIconsConstants.MIST_NIGHT.iconId to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/50n.png"
        )
    }
}
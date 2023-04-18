package com.example.clothingsuggester.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import com.example.clothingsuggester.R
import com.example.clothingsuggester.databinding.FragmentHomeBinding
import com.example.clothingsuggester.model.domain.WeatherMap
import com.example.clothingsuggester.ui.base.BaseFragment
import com.example.clothingsuggester.util.loadImage
import com.example.clothingsuggester.util.toCelsius
import com.example.clothingsuggester.util.toKmPerHour


class HomeFragment : BaseFragment<FragmentHomeBinding>(), IHomeView {

    override val LOG_TAG: String
        get() = this::class.java.simpleName

    override val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    private val homePresenter by lazy { HomePresenter(this) }
    private val getWear by lazy { GetWear() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindWeatherData()
        getSuggestionWear()
    }

    private fun bindWeatherData() {
        val weatherMap = arguments?.getParcelable(WEATHER_MAP) as WeatherMap?

        val countryName = "${weatherMap?.name ?: "-"}, ${weatherMap?.sys?.country ?: "-"}"
        val temperature = "${weatherMap?.main?.temp?.toCelsius() ?: ""}°C"
        val iconId = weatherMap?.weather?.get(0)?.icon
        val highTemperature = "H:${weatherMap?.main?.temp_max?.toCelsius() ?: "0"}° "
        val lowTemperature = "L:${weatherMap?.main?.temp_min?.toCelsius() ?: "0"}° | "
        val feelsLike = "Feels like ${weatherMap?.main?.feels_like?.toCelsius() ?: "0"}°"
        val highLowTemperature = highTemperature + lowTemperature + feelsLike
        val humidity = "${weatherMap?.main?.humidity ?: "0"}%"
        val wind = "${weatherMap?.wind?.speed?.toKmPerHour() ?: "0"} km/h"
        val rain = "${weatherMap?.rain?.oneHour ?: "0"} mm"

        homePresenter.getCurrentWeatherIconUrl(iconId)

        binding.apply {
            textViewCountryName.text = countryName
            textViewTemperature.text = temperature
            textViewHighLow.text = highLowTemperature
            textViewHumidityValue.text = humidity
            textViewWindValue.text = wind
            textViewRainValue.text = rain
        }

    }

    private fun getSuggestionWear() {
        binding.buttonGetDressed.setOnClickListener {

            binding.motionLayoutHome.transitionToState(R.id.start)

            val weatherMap = arguments?.getParcelable(WEATHER_MAP) as WeatherMap?
            val temperature = weatherMap?.main?.temp?.toCelsius()

            binding.imageViewSuggestionForYou.setImageDrawable(
                getWear.suggestWearForToday(temperature)?.let { imageId ->
                    AppCompatResources.getDrawable(
                        requireContext(),
                        imageId
                    )
                }
            )

            binding.motionLayoutHome.transitionToState(R.id.end)
        }
    }

    companion object {

        private const val WEATHER_MAP = "weather_map"
        fun newInstance(weatherMap: WeatherMap?) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(WEATHER_MAP, weatherMap)
                }
            }
    }

    override fun setWeatherImage(imageUrl: String?) {
        imageUrl?.let {
            binding.imageViewTemperature.loadImage(it)
        }
    }

}
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
import com.example.clothingsuggester.util.DataManger
import com.example.clothingsuggester.util.loadImage
import com.example.clothingsuggester.util.toCelsius
import com.example.clothingsuggester.util.toKmPerHour


class HomeFragment : BaseFragment<FragmentHomeBinding>(), IHomeView {

    override val LOG_TAG: String
        get() = this::class.java.simpleName

    override val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    private val homePresenter by lazy { HomePresenter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindWeatherData()
        getSuggestionWear()
    }

    private fun bindWeatherData() {
        val weatherMap = arguments?.getParcelable(WEATHER_MAP) as WeatherMap?

        val iconId = weatherMap?.weather?.get(0)?.icon
        val iconUrl = homePresenter.getCurrentWeatherIconUrl(iconId)

        binding.apply {
            textViewCountryName.text = "${weatherMap?.name}, ${weatherMap?.sys?.country}"
            textViewTemperature.text = "${weatherMap?.main?.temp?.toCelsius()}°C"
            textViewHighLow.text =
                "H:${weatherMap?.main?.temp_max?.toCelsius()}° L:${weatherMap?.main?.temp_min?.toCelsius()}° | Feels like ${weatherMap?.main?.feels_like?.toCelsius()}°"
            textViewHumidityValue.text = "${weatherMap?.main?.humidity}%"
            textViewWindValue.text = "${weatherMap?.wind?.speed?.toKmPerHour()} km/h"
            textViewRainValue.text = "${weatherMap?.rain?.oneHour ?: "0"} mm"
            imageViewTemperature.loadImage(iconUrl)
        }

    }

    private fun getSuggestionWear() {
        binding.buttonGetDressed.setOnClickListener {
            binding.motionLayoutHome.transitionToState(R.id.start)
            binding.imageViewSuggestionForYou.setImageDrawable(AppCompatResources.getDrawable(requireContext(),DataManger.getWearImage().values.first()[0].image))
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

}
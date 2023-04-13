package com.example.clothingsuggester.ui.splash

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.clothingsuggester.R
import com.example.clothingsuggester.databinding.FragmentSplashBinding
import com.example.clothingsuggester.model.domain.WeatherMap
import com.example.clothingsuggester.ui.base.BaseFragment
import com.example.clothingsuggester.ui.home.HomeFragment
import com.example.clothingsuggester.util.Dialog
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng


class SplashFragment : BaseFragment<FragmentSplashBinding>(), ISplashView {

    override val LOG_TAG: String
        get() = this::class.java.simpleName

    override val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> FragmentSplashBinding
        get() = FragmentSplashBinding::inflate

    private val splashPresenter by lazy { SplashPresenter(this) }

    private lateinit var internetConnectionDialog: Dialog
    private lateinit var locationPermissionDialog: Dialog

    private val launchPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                locationPermissionDialog.dismiss()
                fetchCurrentLocation()
            } else {
                Toast.makeText(requireContext(), "عطيني صلاحية بليز", Toast.LENGTH_SHORT).show()
            }
        }

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())
        if (isNetworkConnected(requireContext())) {
            fetchCurrentLocation()
        } else {
            showInternetConnectionDialog()
        }
    }

    private fun fetchCurrentLocation() {
        getCurrentLocation {
            it?.let {
                splashPresenter.getCurrentWeatherMap(it)
            }
        }
    }

    private fun showInternetConnectionDialog() {
        val title = requireContext().getString(R.string.internet_title)
        val description = requireContext().getString(R.string.internet_description)
        val textButton = requireContext().getString(R.string.internet_button)

        internetConnectionDialog = Dialog(requireContext(), title, description, textButton) {
            if (!isNetworkConnected(requireContext())) {
                internetConnectionDialog.show()
            } else {
                internetConnectionDialog.dismiss()
            }
        }

        internetConnectionDialog.show()
    }

    private fun showLocationPermissionDialog() {
        val title = requireContext().getString(R.string.location_permission)
        val description = requireContext().getString(R.string.requires_location)
        val textButton = requireContext().getString(R.string.grant_permission)

        locationPermissionDialog = Dialog(requireContext(), title, description, textButton) {
            launchPermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        locationPermissionDialog.show()
    }

    override fun onSuccessWeather(weatherMap: WeatherMap) {
        navigateToFragment(HomeFragment.newInstance(weatherMap))
    }

    override fun onFailureWeather(error: String) {
        log(error)
    }

    private fun navigateToFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view_main_activity, fragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun getCurrentLocation(getLatLng: (LatLng?) -> Unit) {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->
                location?.let { getLatLng(LatLng(it.latitude, it.longitude)) }
            }
        } else {
            showLocationPermissionDialog()
        }
    }
}
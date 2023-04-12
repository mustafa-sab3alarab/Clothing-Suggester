package com.example.clothingsuggester.ui.splash

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng

class CurrentLocationProvider(private val context: Context) : OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val fusedLocationProviderClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    fun getCurrentLocation(getLatLng: (LatLng?) -> Unit) {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            getLatLng(null)
            return
        }

        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->
            getLatLng(LatLng(location.latitude, location.longitude))
        }
    }
}
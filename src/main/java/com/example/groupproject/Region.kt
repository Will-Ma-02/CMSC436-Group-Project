package com.example.groupproject

import android.content.Context
import android.location.Address
import android.location.Geocoder
import com.google.android.gms.maps.model.LatLng

class Region {

    companion object {
        private val ZERO_LAT_LNG = LatLng(0.toDouble(), 0.toDouble())
        private val ERROR_LAT_LNG = LatLng(Double.MIN_VALUE, Double.MAX_VALUE)
    }

    private var context : Context
    private var toastLength : Int = 0
    private var globalPreferences : GlobalPreferences
    private var countriesBank : CountriesBank

    constructor(context : Context) {
        this.context = context
        this.globalPreferences = GlobalPreferences()
        this.toastLength = globalPreferences.readGlobalEditorToastLength(context)
        this.countriesBank = CountriesBank()
    }

    fun parseCoordinateIntoLatLng(coordinate : String) : LatLng {
        val string : List<String>
        val latitude : Any
        val longitude : Any
        val latitudeMin = (-90).toDouble()
        val latitudeMax = 90.toDouble()
        val longitudeMin = (-180).toDouble()
        val longitudeMax = 180.toDouble()
        try {
            string = coordinate.split(",")
            latitude = string[0]
            longitude = string[1]
            if (LatLng(latitude.toDouble(), longitude.toDouble()) == ZERO_LAT_LNG) {
                return ZERO_LAT_LNG
            }
            if (latitude.toDouble() !in latitudeMin..latitudeMax || longitude.toDouble() !in longitudeMin..longitudeMax) {
                CustomToast.makeText(context, "Out of bound values!", toastLength)
                return ERROR_LAT_LNG
            }
        } catch (e : IndexOutOfBoundsException) {
            return ERROR_LAT_LNG
        } catch (e : NumberFormatException) {
            return ERROR_LAT_LNG
        }
        return try {
            LatLng(latitude.toDouble(), longitude.toDouble())
        } catch (e : NumberFormatException) {
            ERROR_LAT_LNG
        }
    }

    fun parseAddressIntoLatLng(address: String): LatLng {
        val geocoder = Geocoder(context)
        val addresses: MutableList<Address>? = geocoder.getFromLocationName(address, 1)
        if (addresses!!.isNotEmpty()) {
            val latitude: Double = addresses[0].latitude
            val longitude = addresses[0].longitude
            return LatLng(latitude, longitude)
        }
        return ERROR_LAT_LNG
    }

    fun getContinentFromLatLng(latLng: LatLng): String {
        val latitude = latLng.latitude
        val longitude = latLng.longitude
        val geocoder = Geocoder(context)
        val addresses = geocoder.getFromLocation(latitude, longitude, 1)
        return try {
            val continent = countriesBank.countryToContinent(addresses!![0].countryName)
            if (continent != "Unknown") {
                continent
            } else {
                "ERROR"
            }
        } catch (e : IndexOutOfBoundsException) {
            "ERROR"
        }
    }
}
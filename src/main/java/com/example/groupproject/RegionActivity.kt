package com.example.groupproject

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.view.Gravity
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class RegionActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object {
        private val ERROR_LAT_LNG = LatLng(Double.MIN_VALUE, Double.MAX_VALUE)
    }

    private var toastLength : Int = 0
    private lateinit var googleMap: GoogleMap
    private lateinit var mainMenuButton : Button
    private lateinit var addressEditText : EditText
    private lateinit var coordinateEditText : EditText
    private lateinit var globalPreferences : GlobalPreferences
    private lateinit var countriesBank : CountriesBank
    private lateinit var region : Region

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region)

        val fragment : SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        fragment.getMapAsync(this)

        globalPreferences = GlobalPreferences()
        countriesBank = CountriesBank()
        toastLength = globalPreferences.readGlobalEditorToastLength(this)
        region = Region(this)

        mainMenuButton = findViewById(R.id.mainMenuButton)
        addressEditText = findViewById(R.id.addressEditText)
        coordinateEditText = findViewById(R.id.coordinateEditText)

        mainMenuButton.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        buildFilter(addressEditText)
        buildFilter(coordinateEditText)

        addressEditText.setOnEditorActionListener {_, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE || (event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)) {
                val enteredText = addressEditText.text.toString().trim()
                if (enteredText.isNotEmpty() && enteredText.isNotBlank() && region.parseAddressIntoLatLng(enteredText) == ERROR_LAT_LNG) {
                    CustomToast.makeText(this, "Address could not be converted!", toastLength)
                } else if (enteredText.isNotEmpty() && enteredText.isNotBlank() && region.parseAddressIntoLatLng(enteredText) != ERROR_LAT_LNG) {
                    if (region.parseCoordinateIntoLatLng(enteredText) != ERROR_LAT_LNG) {
                        CustomToast.makeText(this, "You might've entered a valid coordinate. Do that on the next line.", toastLength)
                    } else {
                        val location = region.parseAddressIntoLatLng(enteredText)
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))
                        val continent = region.getContinentFromLatLng(location)
                        if (continent != "ERROR") {
                            val toastString = "Selected Category: $continent"
                            CustomToast.makeText(this, toastString, toastLength)
                            globalPreferences.writeGlobalEditorCategoryName(this, continent)
                        } else {
                            CustomToast.makeText(this, "Address/coordinate not supported!", toastLength)
                        }
                    }
                } else {
                    CustomToast.makeText(this, "Please enter a non-empty address!", toastLength)
                }
            }
            false
        }

        coordinateEditText.setOnEditorActionListener {_, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE || (event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)) {
                val enteredText = coordinateEditText.text.toString().trim()
                if (enteredText.isNotEmpty() && enteredText.isNotBlank() && region.parseCoordinateIntoLatLng(enteredText) == ERROR_LAT_LNG) {
                    CustomToast.makeText(this, "Coordinate could not be mapped!", toastLength)
                } else if (enteredText.isNotEmpty() && enteredText.isNotBlank() && region.parseCoordinateIntoLatLng(enteredText) != ERROR_LAT_LNG) {
                    val location = region.parseCoordinateIntoLatLng(enteredText)
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))
                    val continent = region.getContinentFromLatLng(location)
                    if (continent != "ERROR") {
                        val toastString = "Selected Category: $continent"
                        CustomToast.makeText(this, toastString, toastLength)
                        globalPreferences.writeGlobalEditorCategoryName(this, continent)
                    } else {
                        CustomToast.makeText(this, "Address/coordinate not supported!", toastLength)
                    }
                } else {
                    CustomToast.makeText(this, "Please enter a non-empty coordinate!", toastLength)
                }
            }
            false
        }
    }

    private fun buildFilter(editText : EditText) {
        editText.inputType = InputType.TYPE_CLASS_TEXT
        editText.gravity = Gravity.CENTER
        editText.filters = arrayOf(InputFilter.LengthFilter(20))
    }

    override fun onMapReady(p0: GoogleMap) {
        googleMap = p0
    }
}
package com.example.groupproject

import android.content.Context
import com.google.android.material.slider.LabelFormatter

class Settings {

    private var context : Context
    private var globalPreferences : GlobalPreferences
    private var toastLength : Int = 0

    constructor(context : Context) {
        this.context = context
        this.globalPreferences = GlobalPreferences()
        this.toastLength = globalPreferences.readGlobalEditorToastLength(context)
    }

    fun toastLengthSliderHandler(selectedOption: Int) {
        when (selectedOption) {
            0 -> {
                globalPreferences.writeGlobalEditorToastLength(context, 1000)
                toastLength = globalPreferences.readGlobalEditorToastLength(context)
                CustomToast.makeText(context, "Toast duration set to 1 second", toastLength)
            }
            1 -> {
                globalPreferences.writeGlobalEditorToastLength(context, 2000)
                toastLength = globalPreferences.readGlobalEditorToastLength(context)
                CustomToast.makeText(context, "Toast duration set to 2 seconds", toastLength)
            }
            2 -> {
                globalPreferences.writeGlobalEditorToastLength(context, 3000)
                toastLength = globalPreferences.readGlobalEditorToastLength(context)
                CustomToast.makeText(context, "Toast duration set to 3 seconds", toastLength)
            }
        }
    }

    class ToastLengthSliderHandlerLabelFormatter : LabelFormatter {
        override fun getFormattedValue(value: Float): String {
            return when (value.toInt()) {
                0 -> "Short"
                1 -> "Medium"
                2 -> "Long"
                else -> ""
            }
        }
    }
}
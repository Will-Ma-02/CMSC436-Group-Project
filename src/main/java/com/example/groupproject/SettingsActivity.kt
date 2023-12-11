package com.example.groupproject

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

class SettingsActivity : AppCompatActivity() {

    private var toastLength : Int = 0
    private lateinit var globalPreferences : GlobalPreferences
    private lateinit var settings: Settings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        globalPreferences = GlobalPreferences()
        toastLength = globalPreferences.readGlobalEditorToastLength(this)
        settings = Settings(this)

        val activityLayout = LinearLayout(this)
        activityLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        activityLayout.orientation = LinearLayout.VERTICAL
        activityLayout.setPadding(25, 50, 25, 25)

        val titleTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = 25
            }
            text = "Settings"
            textSize = 60f
        }

        val labelTextViewToastLength = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 100
                bottomMargin = 50
            }
            text = "Toast Length"
            textSize = 30f
        }

        val descriptionTextViewToastLength = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = 60
            }
            text = "Set the duration of the toasts"
            textSize = 25f
        }

        val toastLengthSlider = Slider(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                900,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
            }
            value = when (toastLength) {
                1000 -> 0f
                2000 -> 1f
                3000 -> 2f
                else -> 1f
            }
            valueFrom = 0f
            valueTo = 2f
            stepSize = 1f
            thumbTintList = resources.getColorStateList(R.color.black, theme)

            addOnChangeListener { _, value, _ ->
                settings.toastLengthSliderHandler(value.toInt())
            }
        }

        val labelTextViewReset = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 100
                bottomMargin = 50
            }
            text = "Reset Best Score Data"
            textSize = 30f
        }

        val descriptionTextViewReset = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = 60
            }
            text = "Warning: this can't be undone!"
            textSize = 25f
        }

        val resetButton = Button(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
                bottomMargin = 100
            }
            text = "RESET"
            textSize = 20f
        }

        val adView = AdView(this)
        val adSize = AdSize(
            AdSize.FULL_WIDTH,
            AdSize.AUTO_HEIGHT
        )
        adView.setAdSize(adSize)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        val builder : AdRequest.Builder = AdRequest.Builder()
        val request : AdRequest = builder.build()
        adView.loadAd(request)

        val backButton = Button(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 100
                bottomMargin = 100
            }
            text = "Main Menu"
            textSize = 20f
        }

        resetButton.setTextColor(Color.RED)
        toastLengthSlider.setLabelFormatter(Settings.ToastLengthSliderHandlerLabelFormatter())

        activityLayout.addView(titleTextView)
        activityLayout.addView(labelTextViewToastLength)
        activityLayout.addView(descriptionTextViewToastLength)
        activityLayout.addView(toastLengthSlider)
        activityLayout.addView(labelTextViewReset)
        activityLayout.addView(descriptionTextViewReset)
        activityLayout.addView(resetButton)
        activityLayout.addView(adView)
        activityLayout.addView(backButton)
        setContentView(activityLayout)

        resetButton.setOnClickListener() {
            CustomToast.makeText(this, "Best score data has been reset", toastLength)
            globalPreferences.writeGlobalEditorWordleBestScore(this, 7)
        }

        backButton.setOnClickListener() {
            finish()
        }
    }
}
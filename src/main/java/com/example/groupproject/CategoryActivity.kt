package com.example.groupproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CategoryActivity : AppCompatActivity() {

    private var toastLength : Int = 0
    private var categoryName : String? = ""
    private lateinit var globalPreferences : GlobalPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        globalPreferences = GlobalPreferences()
        toastLength = globalPreferences.readGlobalEditorToastLength(this)
        categoryName = globalPreferences.readGlobalEditorCategoryName(this)

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
                topMargin = 25
            }
            text = "Categories"
            textSize = 60f
        }

        val selectedCategoryTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "Selected: $categoryName"
            textSize = 30f
        }

        val customizeTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "Our Categories"
            textSize = 30f
        }

        val categoriesRadioGroup = RadioGroup(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            orientation = RadioGroup.VERTICAL
        }

        val radioButtonGeneral = RadioButton(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "None/Gen"
            textSize = 30f
            id = View.generateViewId()
            gravity = Gravity.START or Gravity.CENTER_VERTICAL
        }

        val radioButtonChristmas = RadioButton(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "Christmas"
            textSize = 30f
            id = View.generateViewId()
            gravity = Gravity.START or Gravity.CENTER_VERTICAL
        }

        val radioButtonUnique = RadioButton(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "All Unique"
            textSize = 30f
            id = View.generateViewId()
            gravity = Gravity.START or Gravity.CENTER_VERTICAL
        }

        val radioButtonNoEs = RadioButton(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "No Char E"
            textSize = 30f
            id = View.generateViewId()
            gravity = Gravity.START or Gravity.CENTER_VERTICAL
        }

        val regionsTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 100
            }
            text = "Regional Categories"
            textSize = 30f
        }

        val regionsButton = Button(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 100
            }
            text = "Pick A Region"
            textSize = 20f
        }

        val backButton = Button(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 125
            }
            text = "Main Menu"
            textSize = 20f
        }

        categoriesRadioGroup.addView(radioButtonGeneral)
        categoriesRadioGroup.addView(radioButtonChristmas)
        categoriesRadioGroup.addView(radioButtonUnique)
        categoriesRadioGroup.addView(radioButtonNoEs)

        when (categoryName) {
            "None/Gen" -> categoriesRadioGroup.check(radioButtonGeneral.id)
            "Christmas" -> categoriesRadioGroup.check(radioButtonChristmas.id)
            "All Unique" -> categoriesRadioGroup.check(radioButtonUnique.id)
            "No Char E" -> categoriesRadioGroup.check(radioButtonNoEs.id)
        }

        regionsButton.setBackgroundColor(Color.GRAY)

        activityLayout.addView(titleTextView)
        activityLayout.addView(selectedCategoryTextView)
        activityLayout.addView(customizeTextView)
        activityLayout.addView(categoriesRadioGroup)
        activityLayout.addView(regionsTextView)
        activityLayout.addView(regionsButton)
        activityLayout.addView(backButton)
        setContentView(activityLayout)

        regionsButton.setOnClickListener() {
            val intent = Intent(this, RegionActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener() {
            finish()
        }

        categoriesRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedRadioButton: RadioButton = findViewById(checkedId)
            when (selectedRadioButton.text.toString()) {
                "None/Gen" -> {
                    CustomToast.makeText(this, "Selected Category: None/Gen", toastLength)
                    globalPreferences.writeGlobalEditorCategoryName(this, "None/Gen")
                    categoryName = globalPreferences.readGlobalEditorCategoryName(this)
                    selectedCategoryTextView.text = "Selected: $categoryName"
                }
                "Christmas" -> {
                    CustomToast.makeText(this, "Selected Category: Christmas", toastLength)
                    globalPreferences.writeGlobalEditorCategoryName(this, "Christmas")
                    categoryName = globalPreferences.readGlobalEditorCategoryName(this)
                    selectedCategoryTextView.text = "Selected: $categoryName"
                }
                "All Unique" -> {
                    CustomToast.makeText(this, "Selected Category: All Unique", toastLength)
                    globalPreferences.writeGlobalEditorCategoryName(this, "All Unique")
                    categoryName = globalPreferences.readGlobalEditorCategoryName(this)
                    selectedCategoryTextView.text = "Selected: $categoryName"
                }
                "No Char E" -> {
                    CustomToast.makeText(this, "Selected Category: No Char E", toastLength)
                    globalPreferences.writeGlobalEditorCategoryName(this, "No Char E")
                    categoryName = globalPreferences.readGlobalEditorCategoryName(this)
                    selectedCategoryTextView.text = "Selected: $categoryName"
                }
            }
        }
    }
}
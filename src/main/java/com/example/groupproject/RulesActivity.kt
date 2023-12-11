package com.example.groupproject

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RulesActivity : AppCompatActivity() {

    private lateinit var rules : Rules
    private var pageNumber : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityLayout = LinearLayout(this)
        activityLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        activityLayout.orientation = LinearLayout.VERTICAL
        activityLayout.setPadding(25, 50, 25, 25)

        rules = Rules()

        val titleTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 25
            }
            textSize = 60f
        }

        val description1 = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                topMargin = 50
            }
            textSize = 30f
        }

        val description2 = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                topMargin = 50
            }
            textSize = 30f
        }

        val description3 = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                topMargin = 50
            }
            textSize = 30f
        }

        val nextButton = Button(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 75
            }
            text = "Next Page"
            textSize = 20f
        }

        val backButton = Button(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 25
            }
            text = "Main Menu"
            textSize = 20f
        }

        val backButton2 = Button(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 135
            }
            text = "Main Menu"
            textSize = 20f
        }

        titleTextView.text = rules.getTitle(pageNumber)
        description1.text = rules.getRule(pageNumber, 1)
        description2.text = rules.getRule(pageNumber, 2)
        description3.text = rules.getRule(pageNumber, 3)

        activityLayout.addView(titleTextView)
        activityLayout.addView(description1)
        activityLayout.addView(description2)
        activityLayout.addView(description3)
        activityLayout.addView(nextButton)
        activityLayout.addView(backButton)
        setContentView(activityLayout)

        nextButton.setOnClickListener() {
            pageNumber++
            titleTextView.text = rules.getTitle(pageNumber)
            description1.text = rules.getRule(pageNumber, 1)
            description2.text = rules.getRule(pageNumber, 2)
            description3.text = rules.getRule(pageNumber, 3)
            if (pageNumber == 4) {
                activityLayout.removeView(nextButton)
                activityLayout.removeView(backButton)
                activityLayout.addView(backButton2)
            }
        }

        backButton.setOnClickListener() {
            finish()
        }

        backButton2.setOnClickListener() {
            finish()
        }
    }
}
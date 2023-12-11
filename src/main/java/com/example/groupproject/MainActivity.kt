package com.example.groupproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

/* Group Members : Xiaoyong Ma, Zichao Liang */
class MainActivity : AppCompatActivity() {

    private lateinit var wordleButton : Button
    private lateinit var customizeButton : Button
    private lateinit var rulesButton : Button
    private lateinit var settingsButton : Button
    private lateinit var closeButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordleButton = findViewById(R.id.wordleButton)
        customizeButton = findViewById(R.id.customizeButton)
        rulesButton = findViewById(R.id.rulesButton)
        settingsButton = findViewById(R.id.settingsButton)
        closeButton = findViewById(R.id.closeButton)

        wordleButton.setOnClickListener() {
            val intent : Intent = Intent(this, WordleActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        customizeButton.setOnClickListener() {
            val intent : Intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        rulesButton.setOnClickListener() {
            val intent : Intent = Intent(this, RulesActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        settingsButton.setOnClickListener() {
            val intent : Intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        closeButton.setOnClickListener() {
            finish()
            exitProcess(0)
        }
    }
}
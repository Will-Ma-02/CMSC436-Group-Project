package com.example.groupproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class WordleLostActivity : AppCompatActivity() {

    private lateinit var wordleLostView: WordleLostView
    private lateinit var intent : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent = getIntent()
        val word = intent.getStringExtra("word")
        val category = intent.getStringExtra("category")
        val bestScore = intent.getIntExtra("bestScore", 7)

        wordleLostView = WordleLostView(this, bestScore)

        setContentView(wordleLostView.buildView(word, category))
    }
}
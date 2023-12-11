package com.example.groupproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class WordleWonActivity : AppCompatActivity() {

    private lateinit var wordleWonView: WordleWonView
    private lateinit var intent : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent = getIntent()
        val userGameRating = intent.getStringExtra("userGameRating")
        val guessesTaken = intent.getIntExtra("guessesTaken", 7)
        val bestScore = intent.getIntExtra("bestScore", 7)

        wordleWonView = WordleWonView(this, userGameRating, guessesTaken, bestScore)
        wordleWonView.setGuessesTaken(guessesTaken)

        setContentView(wordleWonView.buildView(userGameRating, guessesTaken))
    }
}
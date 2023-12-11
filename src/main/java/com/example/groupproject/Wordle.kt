package com.example.groupproject

import android.content.Context
import android.content.SharedPreferences

class Wordle {

    private var grid : MutableList<MutableList<WordleCell>>
    private var word : CharArray
    private var guessCount : Int
    private var bestScore : Int = 7

    constructor(grid : MutableList<MutableList<WordleCell>>, guessCount : Int, word : CharArray) {
        this.grid = grid
        this.guessCount = guessCount
        this.word = word
    }

    fun gameOutcome(maxGuesses : Int) : String {
        for (row in 0..5) {
            if (rowAllGreen(row)) {
               return "WON"
            }
        }
        return if (guessCount <= maxGuesses) {
            "PLAY"
        } else {
            "LOST"
        }
    }

    fun getGuessCount() : Int {
        return guessCount
    }

    fun increaseGuessCount() {
        guessCount++
    }

    private fun rowAllGreen(row : Int) : Boolean {
        for (i in 0..4) {
            if (grid[row][i].getStatus() != "GREEN") {
                return false
            }
        }
        return true
    }

    fun parseGuess(guess : String, turn : Int) {
        val guessAsCharArray : CharArray = guess.toCharArray()
        for (i in 0..4) {
            if (guessAsCharArray[i] == word[i]) {
                grid[turn - 1][i].setLetter(guessAsCharArray[i])
                grid[turn - 1][i].setStatus("GREEN")
            } else if (guessAsCharArray[i] in word && guessAsCharArray[i] != word[i]) {
                grid[turn - 1][i].setLetter(guessAsCharArray[i])
                grid[turn - 1][i].setStatus("YELLOW")
            } else {
                grid[turn - 1][i].setLetter(guessAsCharArray[i])
                grid[turn - 1][i].setStatus("GRAY")
            }
        }
    }

    fun userGameRating(guessesTaken : Int) : String {
        return when (guessesTaken) {
            1 -> "LEGENDARY"
            2 -> "AMAZING"
            3 -> "GREAT"
            4 -> "GOOD"
            5 -> "DECENT"
            6 -> "MEDIOCRE"
            else -> "ERROR"
        }
    }

    fun saveBestScore(context : Context, score : Int) {
        val pref : SharedPreferences = context.getSharedPreferences("Wordle Prefs", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = pref.edit()
        editor.putInt("bestScore", score)
        editor.commit()

        val globalPref : SharedPreferences = context.getSharedPreferences("Global Prefs", Context.MODE_PRIVATE)
        val globalEditor : SharedPreferences.Editor = globalPref.edit()
        globalEditor.putInt("bestScore", score)
        globalEditor.commit()
    }

    fun getBestScore(context : Context) : Int {
        val pref : SharedPreferences = context.getSharedPreferences("Wordle Prefs", Context.MODE_PRIVATE)
        return pref.getInt("bestScore", 7)
    }

    fun setBestScore(newBestScore : Int) {
        this.bestScore = newBestScore
    }

    fun wasBestScore(score : Int) : Boolean {
        return score < bestScore
    }
}
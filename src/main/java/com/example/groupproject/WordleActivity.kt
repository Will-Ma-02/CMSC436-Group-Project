package com.example.groupproject

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.text.Spanned
import android.view.Gravity
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import kotlin.concurrent.schedule

class WordleActivity : AppCompatActivity() {

    private var width : Int = 0
    private var height : Int = 0
    private var toastLength : Int = 0
    private var categoryName : String? = ""
    private lateinit var wordleView : WordleView
    private lateinit var globalPreferences : GlobalPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityLayout = LinearLayout(this)
        activityLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        activityLayout.orientation = LinearLayout.VERTICAL

        val titleTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "Wordle"
            textSize = 60f
        }

        val userInput = EditText(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
                bottomMargin = -100
            }
            hint = "Type Your Guess Here"
            textSize = 30f
        }

        globalPreferences = GlobalPreferences()
        toastLength = globalPreferences.readGlobalEditorToastLength(this)
        categoryName = globalPreferences.readGlobalEditorCategoryName(this)

        width = Resources.getSystem().displayMetrics.widthPixels
        height = Resources.getSystem().displayMetrics.heightPixels
        wordleView = WordleView(this, width, height / 2, categoryName)

        val loadedScoreLocal = wordleView.getWordle().getBestScore(this)
        val loadedScoreGlobal = globalPreferences.readGlobalEditorWordleBestScore(this)
        if (loadedScoreLocal == 7 || loadedScoreGlobal == 7) {
            wordleView.getWordle().setBestScore(7)
        } else {
            wordleView.getWordle().setBestScore(loadedScoreLocal)
        }

        val backButton = Button(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = -250
            }
            text = "Exit Game"
            textSize = 20f
        }

        buildFilter(userInput)
        activityLayout.addView(titleTextView)
        activityLayout.addView(userInput)
        activityLayout.addView(wordleView)
        activityLayout.addView(backButton)
        setContentView(activityLayout)

        backButton.setOnClickListener() {
            finish()
        }

        CustomToast.makeText(this, "You have 6 guesses. Good luck!", toastLength)

        userInput.setOnEditorActionListener { _, actionId, event ->
            val guessCount = wordleView.getWordle().getGuessCount()
            if (actionId == EditorInfo.IME_ACTION_DONE || (event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER && guessCount <= 6)) {
                if (wordleView.getWordle().gameOutcome(6) == "PLAY") {
                    val enteredText = userInput.text.toString().trim()
                    if (enteredText.length == 5) {
                        wordleView.getWordle().parseGuess(enteredText, guessCount)
                        println("Entered text: $enteredText")
                        wordleView.getWordle().increaseGuessCount()
                        userInput.text.clear()
                        wordleView.postInvalidate()
                        val guessesLeft = 6 - guessCount
                        var toastString = ""
                        if (wordleView.getWordle().gameOutcome(6) == "WON") {
                            toastString = "Congratulations, you won!"
                            val userGameRating = wordleView.getWordle().userGameRating(guessCount)
                            if (wordleView.getWordle().wasBestScore(guessCount)) {
                                wordleView.getWordle().saveBestScore(this, guessCount)
                            }
                            val bestScore = wordleView.getWordle().getBestScore(this)
                            val intent = Intent(this, WordleWonActivity::class.java)
                            Timer().schedule(3000.toLong()){
                                runOnUiThread {
                                    intent.putExtra("userGameRating", userGameRating)
                                    intent.putExtra("guessesTaken", guessCount)
                                    intent.putExtra("bestScore", bestScore)
                                    startActivity(intent)
                                }
                            }
                            CustomToast.makeText(this, toastString, toastLength)
                        } else if (wordleView.getWordle().gameOutcome(6) == "LOST") {
                            toastString = "Unfortunately, you lost."
                            val bestScore = wordleView.getWordle().getBestScore(this)
                            val intent = Intent(this, WordleLostActivity::class.java)
                            Timer().schedule(3000.toLong()){
                                runOnUiThread {
                                    intent.putExtra("word", wordleView.getWord())
                                    intent.putExtra("category", categoryName)
                                    intent.putExtra("bestScore", bestScore)
                                    startActivity(intent)
                                }
                            }
                            CustomToast.makeText(this, toastString, toastLength)
                        } else {
                            toastString = if (guessesLeft == 1) {
                                "You have 1 guess left!"
                            } else {
                                "You have $guessesLeft guesses left!"
                            }
                            CustomToast.makeText(this, toastString, toastLength)
                        }
                    } else {
                        CustomToast.makeText(this, "Try again! Enter exactly 5 letters.", toastLength)
                    }
                }
            }
            false
        }
    }

    private fun buildFilter(editText : EditText) {
        editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        editText.gravity = Gravity.CENTER
        editText.filters = arrayOf(Filter(), InputFilter.LengthFilter(5))
    }

    private class Filter : InputFilter {
        override fun filter(
            source: CharSequence?,
            start: Int,
            end: Int,
            dest: Spanned?,
            dstart: Int,
            dend: Int
        ): CharSequence? {
            return source?.filter {
                it.isUpperCase()
            }
        }
    }
}
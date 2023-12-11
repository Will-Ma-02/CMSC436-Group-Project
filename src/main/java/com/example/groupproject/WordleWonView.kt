package com.example.groupproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView

class WordleWonView : View {

    private var context : Context
    private var globalPreferences: GlobalPreferences
    private var userGameRating : String?
    private var guessesTaken : Int = 0
    private var bestScore : Int = 0
    private var toastLength : Int = 0

    constructor(context : Context, userGameRating : String?, guessesTaken : Int, bestScore : Int) : super(context){
        this.context = context
        this.userGameRating = userGameRating
        this.guessesTaken = guessesTaken
        this.bestScore = bestScore
        this.globalPreferences = GlobalPreferences()
        this.toastLength = globalPreferences.readGlobalEditorToastLength(context)
    }

    fun buildView(gameRating : String?, guessesTaken : Int) : View {
        val activityLayout = LinearLayout(context)
        activityLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        activityLayout.orientation = LinearLayout.VERTICAL

        val wonTextView = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "YOU WON!"
            textSize = 60f
        }

        val guessesTakenDescription = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 100
            }
            text = "Guesses Taken: $guessesTaken"
            textSize = 30f
        }

        val bestScoreDescription = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "Best Score: $bestScore"
            textSize = 30f
        }

        val ratingBarUserGameRatingDescription = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 100
            }
            text = "Your Rating this Game"
            textSize = 30f
        }

        val userGameRating = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = gameRating
            textSize = 40f
        }

        val ratingBarUserGameRating = RatingBar(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            rating = (6 - guessesTaken).toFloat()
        }

        val ratingBarAppDescription = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 100
            }
            text = "Rate Our App"
            textSize = 30f
        }

        val ratingBarApp = RatingBar(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
        }

        val wonBackButton = Button(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 200
            }
            text = "Main Menu"
            textSize = 20f
        }

        ratingBarUserGameRating.setIsIndicator(true)

        wonBackButton.setOnClickListener() {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(intent)
            (context as Activity).finish()
        }

        ratingBarApp.setOnRatingBarChangeListener { _, rating, fromUser ->
            var toastString = ""
            if (fromUser) {
                if (rating == 5f) {
                    toastString = "You rated our app $rating stars. YOU'RE AWESOME JUST LIKE OUR APP!"
                    CustomToast.makeText(context, toastString, toastLength)
                } else if (rating >= 4f && rating < 5f) {
                    toastString = "You rated our app $rating stars. Glad you're loving it context much!"
                    CustomToast.makeText(context, toastString, toastLength)
                } else if (rating >= 3f && rating < 4f) {
                    toastString = "You rated our app $rating stars. Sounds like you had a decent experience."
                    CustomToast.makeText(context, toastString, toastLength)
                } else if (rating >= 2f && rating < 3f) {
                    toastString = "You rated our app $rating stars. We hope we didn't disappoint you."
                    CustomToast.makeText(context, toastString, toastLength)
                } else if (rating >= 1f && rating < 2f) {
                    toastString = "You rated our app $rating stars. We're sorry you didn't really enjoy it."
                    CustomToast.makeText(context, toastString, toastLength)
                } else if (rating < 1f) {
                    toastString = "You rated our app $rating stars. Please tell us what we can do better."
                    CustomToast.makeText(context, toastString, toastLength)
                }
            }
        }

        activityLayout.addView(wonTextView)
        activityLayout.addView(guessesTakenDescription)
        activityLayout.addView(bestScoreDescription)
        activityLayout.addView(ratingBarUserGameRatingDescription)
        activityLayout.addView(userGameRating)
        activityLayout.addView(ratingBarUserGameRating)
        activityLayout.addView(ratingBarAppDescription)
        activityLayout.addView(ratingBarApp)
        activityLayout.addView(wonBackButton)
        return activityLayout
    }

    fun setGuessesTaken(newGuessesTaken : Int) {
        this.guessesTaken = newGuessesTaken
    }
}
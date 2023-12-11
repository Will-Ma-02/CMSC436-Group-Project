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
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

class WordleLostView : View {

    private var context: Context
    private var globalPreferences: GlobalPreferences
    private var bestScore : Int = 0
    private var toastLength : Int = 0

    constructor(context : Context, bestScore : Int) : super(context) {
        this.context = context
        this.bestScore = bestScore
        this.globalPreferences = GlobalPreferences()
        this.toastLength = globalPreferences.readGlobalEditorToastLength(context)
    }

    fun buildView(word: String?, category: String?) : View {
        val activityLayout = LinearLayout(context)
        activityLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        activityLayout.orientation = LinearLayout.VERTICAL

        val lostTextView = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "YOU LOST!"
            textSize = 60f
        }

        val lostDescription = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 100
            }
            text = "Better luck next time!"
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

        val categoryDescription = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "Category: $category"
            textSize = 30f
        }

        val wordDescription = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 50
            }
            text = "The word was: $word"
            textSize = 30f
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
                bottomMargin = 100
            }
        }

        val adView = AdView(context)
        val adSize = AdSize(
            AdSize.FULL_WIDTH,
            AdSize.AUTO_HEIGHT
        )
        adView.setAdSize(adSize)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        val builder: AdRequest.Builder = AdRequest.Builder()
        val request: AdRequest = builder.build()
        adView.loadAd(request)

        val lostBackButton = Button(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = 150
            }
            text = "Main Menu"
            textSize = 20f
        }

        lostBackButton.setOnClickListener() {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(intent)
            (context as Activity).finish()
        }

        ratingBarApp.setOnRatingBarChangeListener { _, rating, fromUser ->
            var toastString = ""
            if (fromUser) {
                if (rating == 5f) {
                    toastString =
                        "You rated our app $rating stars. YOU'RE AWESOME JUST LIKE OUR APP!"
                    CustomToast.makeText(context, toastString, toastLength)
                } else if (rating >= 4f && rating < 5f) {
                    toastString =
                        "You rated our app $rating stars. Glad you're loving it this much!"
                    CustomToast.makeText(context, toastString, toastLength)
                } else if (rating >= 3f && rating < 4f) {
                    toastString =
                        "You rated our app $rating stars. Sounds like you had a decent experience."
                    CustomToast.makeText(context, toastString, toastLength)
                } else if (rating >= 2f && rating < 3f) {
                    toastString =
                        "You rated our app $rating stars. We hope we didn't disappoint you."
                    CustomToast.makeText(context, toastString, toastLength)
                } else if (rating >= 1f && rating < 2f) {
                    toastString =
                        "You rated our app $rating stars. We're sorry you didn't really enjoy it."
                    CustomToast.makeText(context, toastString, toastLength)
                } else if (rating < 1f) {
                    toastString =
                        "You rated our app $rating stars. Please tell us what we can do better."
                    CustomToast.makeText(context, toastString, toastLength)
                }
            }
        }
        activityLayout.addView(lostTextView)
        activityLayout.addView(lostDescription)
        activityLayout.addView(bestScoreDescription)
        activityLayout.addView(categoryDescription)
        activityLayout.addView(wordDescription)
        activityLayout.addView(ratingBarAppDescription)
        activityLayout.addView(ratingBarApp)
        activityLayout.addView(adView)
        activityLayout.addView(lostBackButton)
        return activityLayout
    }
}
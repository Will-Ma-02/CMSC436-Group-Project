package com.example.groupproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View

class WordleView : View {

    private var grid : MutableList<MutableList<WordleCell>> = ArrayList()
    private var word : CharArray = charArrayOf()
    private var width : Int
    private var height : Int
    private var paint : Paint
    private val rows = 6
    private val cols = 5
    private val squareSize = 175
    private val offset = 15
    private var wordleBank : WordleBank
    private var wordle : Wordle

    constructor(context : Context, width : Int, height : Int, categoryName : String?) : super(context) {
        this.width = width
        this.height = height

        paint = Paint()
        paint.strokeWidth = 20f
        paint.isAntiAlias = true

        grid = MutableList(rows * cols) {
            MutableList(cols) {
                WordleCell(null, "DEFAULT")
            }
        }

        wordleBank = WordleBank()
        word = wordleBank.wordPicker(categoryName).uppercase().toCharArray()

        wordle = Wordle(grid, 1, word)
        // Log.w("Word", word.joinToString("")) // FOR DEBUGGING PURPOSES, COMMENT OUT AFTERWARDS
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val totalWidth = cols * squareSize + (cols - 1) * offset
        val startX = (width - totalWidth) / 2
        val startY = 200

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                val wordleCell = grid[row][col]
                when (wordleCell.getStatus()) {
                    "GRAY" -> paint.color = Color.rgb(120, 124, 127)
                    "YELLOW" -> paint.color = Color.rgb(200, 182, 83)
                    "GREEN" -> paint.color = Color.rgb(108, 169, 101)
                    "DEFAULT" -> paint.color = Color.rgb(200, 200, 200)
                }

                val left = startX + col * (squareSize + offset)
                val top = startY + row * (squareSize + offset)
                val right = left + squareSize
                val bottom = top + squareSize
                canvas.drawRect(
                    left.toFloat(),
                    top.toFloat(),
                    right.toFloat(),
                    bottom.toFloat(),
                    paint
                )

                paint.color = Color.WHITE
                paint.textSize = 100f
                paint.textAlign = Paint.Align.CENTER

                val centerX = left + squareSize / 2
                val centerY = top + squareSize / 2

                val letter : String = if (wordleCell.getLetter() == null) {
                    ""
                } else {
                    wordleCell.getLetter().toString()
                }

                canvas.drawText(
                    letter,
                    centerX.toFloat(),
                    centerY.toFloat() + 35f,
                    paint
                )
            }
        }
    }

    fun getWordle() : Wordle {
        return wordle
    }

    fun getWord() : String {
        return word.joinToString("")
    }
}
package com.example.groupproject

class Rules {

    companion object {
        private const val TITLE_PAGE_1 = "General"
        private const val RULES_PAGE_1_PARAGRAPH_1 = "Tired of playing your daily Wordle? Do you wish you had the option to customize your word bank?"
        private const val RULES_PAGE_1_PARAGRAPH_2 = "Catawordle, by Xiaoyong Ma and Zichao Liang, is a new and refreshing twist on this classic."
        private const val RULES_PAGE_1_PARAGRAPH_3 = "Select one of our pre-made categories, or even better, turn your favorite places into one!"

        private const val TITLE_PAGE_2 = "Wordle"
        private const val RULES_PAGE_2_PARAGRAPH_1 = "You have 6 chances to guess a 5 letter word. Each time you guess, you will be given some clues."
        private const val RULES_PAGE_2_PARAGRAPH_2 = "Colors are the key. A gray square means the letter you guessed is not in the word at all."
        private const val RULES_PAGE_2_PARAGRAPH_3 = "A yellow square means a correct letter but wrong position, and green is correct for both."

        private const val TITLE_PAGE_3 = "Categories"
        private const val RULES_PAGE_3_PARAGRAPH_1 = "Our flagship feature is allowing you to customize the word bank through 2 different ways."
        private const val RULES_PAGE_3_PARAGRAPH_2 = "You can select one of our pre-made categories. The default category selected is None/Gen."
        private const val RULES_PAGE_3_PARAGRAPH_3 = "If you feel fancy, turn your favorite location into a continental category (except Antarctica)."

        private const val TITLE_PAGE_4 = "Bugs/Future"
        private const val RULES_PAGE_4_PARAGRAPH_1 = "The emulator is a bit buggy on some features, especially Google Maps. You may have performance issues."
        private const val RULES_PAGE_4_PARAGRAPH_2 = "The Google Maps API costs us money to use. This feature will not be available in the future."
        private const val RULES_PAGE_4_PARAGRAPH_3 = "That's all we have for you for now. We hope you enjoy our app, and make sure to rate it too!"
    }

    fun getTitle(page : Int) : String {
        return when (page) {
            1 -> TITLE_PAGE_1
            2 -> TITLE_PAGE_2
            3 -> TITLE_PAGE_3
            4 -> TITLE_PAGE_4
            else -> "ERROR"
        }
    }

    fun getRule(page : Int, paragraph : Int) : String{
        return when (page) {
            1 -> {
               return when (paragraph) {
                   1 -> RULES_PAGE_1_PARAGRAPH_1
                   2 -> RULES_PAGE_1_PARAGRAPH_2
                   3 -> RULES_PAGE_1_PARAGRAPH_3
                   else -> "ERROR"
               }
            }
            2 -> {
                return when (paragraph) {
                    1 -> RULES_PAGE_2_PARAGRAPH_1
                    2 -> RULES_PAGE_2_PARAGRAPH_2
                    3 -> RULES_PAGE_2_PARAGRAPH_3
                    else -> "ERROR"
                }
            }
            3 -> {
                return when (paragraph) {
                    1 -> RULES_PAGE_3_PARAGRAPH_1
                    2 -> RULES_PAGE_3_PARAGRAPH_2
                    3 -> RULES_PAGE_3_PARAGRAPH_3
                    else -> "ERROR"
                }
            }
            4 -> {
                return when (paragraph) {
                    1 -> RULES_PAGE_4_PARAGRAPH_1
                    2 -> RULES_PAGE_4_PARAGRAPH_2
                    3 -> RULES_PAGE_4_PARAGRAPH_3
                    else -> "ERROR"
                }
            }
            else -> "ERROR"
        }
    }
}
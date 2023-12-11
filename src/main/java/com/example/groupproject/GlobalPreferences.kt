package com.example.groupproject

import android.content.Context
import android.content.SharedPreferences

class GlobalPreferences {

    fun writeGlobalEditorWordleBestScore(context : Context, score : Int) {
        val globalPref : SharedPreferences = context.getSharedPreferences("Global Prefs", Context.MODE_PRIVATE)
        val globalEditor : SharedPreferences.Editor = globalPref.edit()
        globalEditor.putInt("bestScore", score)
        globalEditor.commit()

        val pref : SharedPreferences = context.getSharedPreferences("Wordle Prefs", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = pref.edit()
        editor.putInt("bestScore", score)
        editor.commit()
    }

    fun readGlobalEditorWordleBestScore(context : Context) : Int {
        val pref : SharedPreferences = context.getSharedPreferences("Global Prefs", Context.MODE_PRIVATE)
        return pref.getInt("bestScore", 7)
    }

    fun writeGlobalEditorToastLength(context : Context, value : Int) {
        val globalPref : SharedPreferences = context.getSharedPreferences("Global Prefs", Context.MODE_PRIVATE)
        val globalEditor : SharedPreferences.Editor = globalPref.edit()
        globalEditor.putInt("toastLength", value)
        globalEditor.commit()
    }

    fun readGlobalEditorToastLength(context : Context) : Int {
        val pref : SharedPreferences = context.getSharedPreferences("Global Prefs", Context.MODE_PRIVATE)
        return pref.getInt("toastLength", 2000)
    }

    fun writeGlobalEditorCategoryName(context : Context, category : String) {
        val globalPref : SharedPreferences = context.getSharedPreferences("Global Prefs", Context.MODE_PRIVATE)
        val globalEditor : SharedPreferences.Editor = globalPref.edit()
        globalEditor.putString("categoryName", category)
        globalEditor.commit()
    }

    fun readGlobalEditorCategoryName(context : Context) : String? {
        val pref : SharedPreferences = context.getSharedPreferences("Global Prefs", Context.MODE_PRIVATE)
        return pref.getString("categoryName", "None/Gen")
    }
}
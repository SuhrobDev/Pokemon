package com.example.pokemon.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {

    private var preferences: SharedPreferences =
        context.getSharedPreferences("APP_PREFS_NAME", Context.MODE_PRIVATE)

    private lateinit var editor: SharedPreferences.Editor

    fun setType(type: Int) {
        editor = preferences.edit()
        editor.putInt("type", type).apply()
    }

    fun getType(): Int {
        return preferences.getInt("type", 0)
    }

}
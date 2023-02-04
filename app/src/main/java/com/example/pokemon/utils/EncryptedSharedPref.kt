package com.example.pokemon.utils

import android.content.Context
import android.content.SharedPreferences

class EncryptedSharedPref(context: Context) {

//    private var sharedPreference: EncryptedSharedPref? = null

//    private val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
//    private val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
//    private val securePreferences = EncryptedSharedPreferences.create(
//        "birzoom_secure",
//        mainKeyAlias,
//        context,
//        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
//        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
//    )

    private var preferences: SharedPreferences =
        context.getSharedPreferences("APP_PREFS_NAME", Context.MODE_PRIVATE)

    private lateinit var editor: SharedPreferences.Editor

//    fun getInstance(context: Context): EncryptedSharedPref {
//        return if (sharedPreference != null) sharedPreference!! else EncryptedSharedPref(context).also {
//            sharedPreference = it
//        }
//    }

//    private val editor: SharedPreferences.Editor = securePreferences.edit()

    fun setToken(token: String) {
        editor = preferences.edit()
        editor.putString("token", token)
        editor.apply()
    }


    fun getToken(): String {
        return preferences.getString("token", "") ?: ""
    }

    fun setLanguageId(token: String) {
        editor = preferences.edit()
        editor.putString("LanguageId", token)
        editor.apply()
    }

    fun getLanguageId(): String {
        return preferences.getString("LanguageId", "") ?: ""
    }

    fun setLanguageImage(token: String) {
        editor = preferences.edit()
        editor.putString("LanguageImage", token)
        editor.apply()
    }

    fun getLanguageImage(): String {
        return preferences.getString("LanguageImage", "") ?: ""
    }

    fun setFCMToken(token: String) {
        editor = preferences.edit()
        editor.putString("token1", token)
        editor.apply()
    }

    fun getFCMToken(): String {
        return preferences.getString("token1", "") ?: ""
    }

    fun getRecognition(): Int {
        return preferences.getInt("Recognition", 0)
    }

    fun setRecognition(token: Int) {
        editor = preferences.edit()
        editor.putInt("Recognition", token)
        editor.apply()
    }

    fun setMatching(token: Int) {
        editor = preferences.edit()
        editor.putInt("Matching", token)
        editor.apply()
    }


    fun getMatching(): Int {
        return preferences.getInt("Matching", 0)
    }

    fun setTranslate(token: Int) {
        editor = preferences.edit()
        editor.putInt("Translate", token)
        editor.apply()
    }


    fun getTranslate(): Int {
        return preferences.getInt("Translate", 0)
    }

    fun setSpeaking(token: Int) {
        editor = preferences.edit()
        editor.putInt("Speaking", token)
        editor.apply()
    }

    fun getSpeaking(): Int {
        return preferences.getInt("Speaking", 0)
    }

    fun setOrder(token: Int) {
        editor = preferences.edit()
        editor.putInt("Order", token)
        editor.apply()
    }

    fun getOrder(): Int {
        return preferences.getInt("Order", 0)
    }

    fun setMultiple(token: Int) {
        editor = preferences.edit()
        editor.putInt("Multiple", token)
        editor.apply()
    }

    fun getMultiple(): Int {
        return preferences.getInt("Multiple", 0)
    }

    fun setVocabulary(token: Int) {
        editor = preferences.edit()
        editor.putInt("vocabulary", token)
        editor.apply()
    }

    fun getVocabulary(): Int {
        return preferences.getInt("vocabulary", 0)
    }

    fun setHasToken(hasToken: Boolean) {
        editor = preferences.edit()
        editor.putBoolean("hasToken", hasToken)
        editor.apply()
    }

    fun getHasToken(): Boolean {
        return preferences.getBoolean("hasToken", false)
    }


    fun setDialog(hasToken: Boolean) {
        editor = preferences.edit()

        editor.putBoolean("dialog", hasToken)
        editor.apply()
    }

    fun getDialog(): Boolean {
        return preferences.getBoolean("dialog", true)
    }

    fun setNightMode(hasToken: Boolean) {
        editor = preferences.edit()

        editor.putBoolean("nightMode", hasToken)
        editor.apply()
    }

    fun getNightMode(): Boolean {
        return preferences.getBoolean("nightMode", false)
    }

    fun setID(id: String) {
        editor = preferences.edit()

        editor.putString("id", id)
        editor.apply()
    }

    fun getID(): String {
        return preferences.getString("id", "") ?: ""
    }

    fun setLanguage(language: String) {
        editor = preferences.edit()

        editor.putString("language", language)
        editor.apply()
    }

    fun getLanguage(): String {
        return preferences.getString("language", "") ?: ""
    }

    fun setTestResult(language: String) {
        editor = preferences.edit()

        editor.putString("test", language)
        editor.apply()
    }

    fun getTestResult(): String {
        return preferences.getString("test", "") ?: ""
    }

    fun setPassword(string: String) {
        editor = preferences.edit()

        editor.putString("password", string).apply()
    }

    fun getPassword(): String {
        return preferences.getString("password", "") ?: ""
    }

    fun setClickPermission(count: Int) {
        editor = preferences.edit()

        editor.putInt("count", count).apply()
    }

    fun getClickPermission(): Int {
        return preferences.getInt("count", 0)
    }

    fun addSpeakingText(text: String) {
        editor = preferences.edit()

        editor.putString("speakingText", text).apply()
    }

    fun getSpeakingText(): String {
        return preferences.getString("speakingText", "")!!
    }

    fun clearSpeakingText() {
        editor = preferences.edit()
        editor.putString("speakingText", "").apply()
    }
}
package com.feylabs.lasagna.util.SharedPreference

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    companion object{
        const val PENDAHULUAN1 = "QFEQCD"
        const val PENDAHULUAN2 = "DDAWQFQ"
        const val PENDAHULUAN3 = "DDAD"
    }

    private val PREFS_NAME = "kotlinpref"
    val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPref.edit()


    fun save(KEY_NAME: String, value: Int) {
        editor.putInt(KEY_NAME, value)
        editor.commit()
    }

    fun removeKey(KEY_NAME: String) {
        editor.remove(KEY_NAME)
        editor.commit()
    }

    fun save(KEY_NAME: String, value: String) {
        editor.putString(KEY_NAME, value)
        editor.commit()
    }

    fun save(KEY_NAME: String, value: Boolean) {
        editor.putBoolean(KEY_NAME, value)
        editor.commit()
    }

    fun getPrefBool(KEY_NAME: String): Boolean? {
        return sharedPref.getBoolean(KEY_NAME, false)
    }

    fun getPrefString(KEY_NAME: String): String? {
        return sharedPref.getString(KEY_NAME, null)
    }

    fun getPrefInt(KEY_NAME: String): Int? {
        return sharedPref.getInt(KEY_NAME,-9999)
    }


    fun clearPreferences() {
        editor.clear()
        editor.commit()
    }

}
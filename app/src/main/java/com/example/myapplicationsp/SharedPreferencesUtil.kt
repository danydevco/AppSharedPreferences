package com.example.myapplicationsp

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesUtil {
    companion object {
        private const val PREF_NAME = "mySP"

        private fun getPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        }

        fun getString(context: Context, key: String, defaultValue: String = ""): String {
            val sp = getPreferences(context)
            return sp.getString(key, defaultValue) ?: defaultValue
        }

        fun getDouble(context: Context, key: String, defaultValue: Double = 0.0): Double {
            val sp = getPreferences(context)
            return sp.getFloat(key, defaultValue.toFloat()).toDouble()
        }

        fun putString(context: Context, key: String, value: String) {
            val sp = getPreferences(context)
            val editor = sp.edit()
            editor.putString(key, value)
            editor.apply()
        }

        fun delete(context: Context, key: String){
            val sp = getPreferences(context)
            val editor = sp.edit()
            editor.remove(key)
            editor.apply()
        }

    }
}
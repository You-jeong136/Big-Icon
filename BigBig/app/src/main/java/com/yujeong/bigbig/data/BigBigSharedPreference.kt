package com.yujeong.bigbig.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object BigBigSharedPreference  {
    lateinit var preferences: SharedPreferences

    private const val REQUEST_CONTACT_FIRST = "REQUEST_CONTACT_FIRST"

    fun init(context: Context) {
        preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    fun setContactFisrt(value : Boolean){
        preferences.edit{
            putBoolean(REQUEST_CONTACT_FIRST, value)
            apply()
        }
    }

    fun getContactFirst(): Boolean = preferences.getBoolean(REQUEST_CONTACT_FIRST, true)


    fun clearStorage() : Boolean{
        return preferences.edit().clear().commit()
    }
}

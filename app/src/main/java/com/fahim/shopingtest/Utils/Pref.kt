package com.fahim.shopingtest.Utils

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class Pref constructor(public var context: Context) {
    companion object {
        lateinit var sharedPreference: SharedPreferences
        lateinit var editor: Editor
    }

    init {
        sharedPreference = context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        editor = sharedPreference.edit()

    }


}
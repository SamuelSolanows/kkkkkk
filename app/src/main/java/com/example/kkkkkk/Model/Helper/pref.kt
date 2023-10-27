package com.example.kkkkkk.Model.Helper

import android.content.Context

class pref(val contex: Context) {

    val SEXO = "sexo"
    var sharepreference = contex.getSharedPreferences(SEXO, 0)

    fun SaveSexo(sexo: String) {
        sharepreference.edit().putString(SEXO, sexo)
    }

    fun GetSexo(): String {
        return ""
    }
}
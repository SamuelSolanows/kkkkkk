package com.example.kkkkkk.Model.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Api {
    private val retrofit =
        Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build()
    var build = retrofit.create(ApiService::class.java)
}
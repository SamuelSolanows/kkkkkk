package com.example.kkkkkk.Model.Api

import com.example.kkkkkk.Model.Models.Sexo
import com.example.kkkkkk.Model.Models.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("Sexo")
    fun GetAllSexo(): Call<List<Sexo>>

    @GET("Sexo/{id}")
    fun GetSexoId(@Path("id") id: String): Call<Sexo>

    @POST("Sexo")
    fun PostSexo(@Body sexo: Sexo): Call<Sexo>

    @DELETE("Sexo/{id}")
    fun DeleteSexo(@Path("id") id: String): Call<Sexo>

    @PUT("Sexo/{id}")
    fun PutSexo(@Path("id") id: String, @Body sexo: Sexo): Call<Sexo>


    @GET("Sexo")
    fun GetAllUsuario(): Call<List<Usuario>>

    @GET("Usuario/{id}")
    fun GetUsuarioId(@Path("id") id: String): Call<Usuario>

    @POST("Usuario")
    fun PostUsuario(@Body usuario: Usuario): Call<Usuario>

    @DELETE("Usuario/{id}")
    fun DeleteUsuario(@Path("id") id: String): Call<Usuario>

    @PUT("Usuario/{id}")
    fun PutUsuario(@Path("id") id: String, @Body usuario: Usuario): Call<Usuario>

}
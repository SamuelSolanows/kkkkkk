package com.example.kkkkkk.Model.DB.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.kkkkkk.Model.Models.Usuario

@Dao
interface daoUsuario {
    @Insert(onConflict = IGNORE)
    fun InsertUsuario(usuario: Usuario)

    @Delete
    fun DeleteUsuario(usuario: Usuario)

    @Query("SELECT * FROM TUsuario")
    fun GetUsuarios(): List<Usuario>
}
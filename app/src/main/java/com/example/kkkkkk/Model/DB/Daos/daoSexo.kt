package com.example.kkkkkk.Model.DB.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.kkkkkk.Model.Models.Sexo

@Dao
interface daoSexo {
    @Insert(onConflict = IGNORE)
    fun InsertSexo(sexo: Sexo)

    @Delete
    fun Delete(sexo: Sexo)

    @Query("SELECT * FROM tsexo")
    fun GeTAllSexo(): List<Sexo>
}
package com.example.kkkkkk.Model.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kkkkkk.Model.DB.Daos.daoSexo
import com.example.kkkkkk.Model.DB.Daos.daoUsuario
import com.example.kkkkkk.Model.Models.Sexo
import com.example.kkkkkk.Model.Models.Usuario


@Database(entities = [Sexo::class, Usuario::class], version = 1)
abstract class DBConexion : RoomDatabase() {
    abstract fun SexoDao(): daoSexo
    abstract fun UsuarioDao(): daoUsuario

    companion object {
        private var INSTANCIA: DBConexion? = null

        fun GetDataBase(context: Context): DBConexion {
            if (INSTANCIA != null) {
                return INSTANCIA!!
            }

            INSTANCIA =
                Room.databaseBuilder(context.applicationContext, DBConexion::class.java, "DB")
                    .build()
            return INSTANCIA!!
        }
    }

}
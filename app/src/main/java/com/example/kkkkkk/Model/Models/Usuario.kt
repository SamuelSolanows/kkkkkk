package com.example.kkkkkk.Model.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "TUsuario",
    foreignKeys = [ForeignKey(
        entity = Sexo::class,
        parentColumns = ["ID"],
        childColumns = ["IDSexo"]
    )]
)
data class Usuario(
    @PrimaryKey(autoGenerate = true) val ID: Long,
    @ColumnInfo val Nombre: String,
    @ColumnInfo val Apellido: String,
    @ColumnInfo val Correo: String,
    @ColumnInfo val Telefono: String,
    @ColumnInfo val IDSexo: Long
)

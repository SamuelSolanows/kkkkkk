package com.example.kkkkkk.Model.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TSexo")
data class Sexo(@PrimaryKey(autoGenerate = true) val ID: Long, @ColumnInfo val Nombre: String)

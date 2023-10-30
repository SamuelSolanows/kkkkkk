package com.example.kkkkkk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Insert
import com.example.kkkkkk.Model.Adapter.Item_Adapter
import com.example.kkkkkk.Model.DB.DBConexion
import com.example.kkkkkk.Model.Models.Sexo
import com.example.kkkkkk.Model.Models.Usuario
import com.example.kkkkkk.databinding.ActivityMainBinding
import com.example.kkkkkk.databinding.ItemAdapterBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var db: DBConexion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DBConexion.GetDataBase(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btn.setOnClickListener {
                Rview.adapter = Item_Adapter(ConsumoRaw().toMutableList())
            }

        }
    }

    override fun onStop() {
        super.onStop()
        Log.e("asdsa", "Cerrao")
    }

    private fun InsertarUsuario() {
        CoroutineScope(Dispatchers.IO).launch {
            var newusuario =
                Usuario(2, "geider", "morelo", "Samuelsolanoama@gmail.com", "3244123104", 1)
            db.UsuarioDao().InsertUsuario(newusuario)
            var lista = db.UsuarioDao().GetUsuarios()
            runOnUiThread {
                Log.e("EEE", lista.toString())
            }
        }
    }

    private fun InsertSexo() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                var newSexo = Sexo(2, "Masculino")
                db.SexoDao().InsertSexo(newSexo)
                var list = db.SexoDao().GeTAllSexo()
                Log.e("Sexos", list.toString())
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }

        }
    }

    private fun getSexo() {
        CoroutineScope(Dispatchers.IO).launch {

            var list = db.SexoDao().GeTAllSexo()
            var lis2 = db.UsuarioDao().GetUsuarios()
            runOnUiThread {
                binding.Rview.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.Rview.adapter = Item_Adapter(list.toMutableList())
            }
        }
    }


    private fun ConsumoRaw(): List<Sexo> {
        val rutaArchivo = "res/raw/data.json"
        val inputStream = this.javaClass.classLoader.getResourceAsStream(rutaArchivo)
        try {
            val read = BufferedReader(InputStreamReader(inputStream)).readText()
            val listType: Type = object : TypeToken<List<Sexo>>() {}.type
            return Gson().fromJson(read, listType)
        } catch (e: Exception) {
            Log.e("rrrr", e.message.toString())
        }
        return emptyList()

    }


    fun consumoRaw(): List<Sexo> {
        val res = resources

        val filePath = "res/raw/data.json"
        val inputStream = this.javaClass.classLoader.getResourceAsStream(filePath)
        try {
            val reader = BufferedReader(InputStreamReader(inputStream))
            val json = reader.readText()
            val listType: Type? = object : TypeToken<List<Sexo>>() {}.type
            return Gson().fromJson(json, listType)

        } catch (e: IOException) {
            Log.e("kkkk", e.message.toString())
        }
        return emptyList()
    }

}
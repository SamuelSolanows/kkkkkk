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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var db: DBConexion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DBConexion.GetDataBase(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        k()
        binding.apply {
            btn.setOnClickListener {
                getSexo()
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
                binding.Rview.adapter = Item_Adapter(list.toMutableList(), lis2.toMutableList())
            }
        }
    }


    fun k() {
        var bing: ItemAdapterBinding
        bing = ItemAdapterBinding.inflate(layoutInflater)
        bing.btn.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }
    }

//    private fun ConsumoRaw(): List<Usuario> {
//        val rutaArchivo = "res/raw/data.json"
//        val imputStream =
//
//            return
//
//    }


    fun a() {
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }


            override fun onFinish() {

            }
        }
    }
}
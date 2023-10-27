package com.example.kkkkkk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Insert
import com.example.kkkkkk.Model.DB.DBConexion
import com.example.kkkkkk.Model.Models.Sexo
import com.example.kkkkkk.Model.Models.Usuario
import com.example.kkkkkk.databinding.ActivityMainBinding
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

        binding.apply {
            btn.setOnClickListener {
                InsertarUsuario()
            }
        }
    }

    private fun InsertarUsuario() {
        CoroutineScope(Dispatchers.IO).launch {
            var newusuario =
                Usuario(1, "Samuel", "Solano", "Samuelsolanoama@gmail.com", "3244123104", 1)
            // db.UsuarioDao().InsertUsuario(newusuario)
            var lista = db.UsuarioDao().GetUsuarios()
            runOnUiThread {
                Log.e("EEE", lista.toString())
            }
        }
    }

    private fun InsertSexo() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                var newSexo = Sexo(1, "Masculino")
                db.SexoDao().InsertSexo(newSexo)
                var list = db.SexoDao().GeTAllSexo()
                Log.e("Sexos", list.size.toString())
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }

        }
    }

    private fun getSexo() {
        CoroutineScope(Dispatchers.IO).launch {
            var list = db.SexoDao().GeTAllSexo()
            runOnUiThread {
                Toast.makeText(this@MainActivity, list.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
package com.example.myapplicationsp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationsp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configuración del view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Interfas para acceder a click del botón
        binding.btSend.setOnClickListener {
            val user = binding.etUser.text.toString()

            // Gauardar el usuario en SharedPreferences
            SharedPreferencesUtil.putString(this, "user", user)

            // Toast
            Toast.makeText(this, "Usuario guardado", Toast.LENGTH_SHORT).show()

        }

        // LLamar a la función que obtiene una cadena de SharedPreferences
        val user =SharedPreferencesUtil.getString(this, "user")
        SharedPreferencesUtil.delete(this, "user")
        binding.tvUserRecuperado.text = user
    }


}
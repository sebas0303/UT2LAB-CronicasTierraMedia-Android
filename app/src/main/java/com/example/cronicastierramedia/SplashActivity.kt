package com.example.cronicastierramedia

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Usamos un Handler ligado al Looper principal para retrasar la ejecución
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // 🌟 CRÍTICO: Finalizamos la Splash para que el usuario no vuelva a ella al pulsar "Atrás"
        }, 3000) // 3000 milisegundos = 3 segundos
    }
}
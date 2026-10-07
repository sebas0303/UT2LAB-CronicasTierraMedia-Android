package com.example.cronicastierramedia

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnComunidad = findViewById<Button>(R.id.btnComunidad)
        val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
        val tvContador = findViewById<TextView>(R.id.tvContador)

        Log.d("Rivendell", "El Anillo comienza su viaje en Rivendell")

        btnComunidad.setOnClickListener {
            contador++
            tvSaludo.text = "¡La Comunidad del Anillo ha partido hacia Mordor!"
            tvContador.text = "Miembros reunidos: $contador"
        }


        //ayuda de IA para pasar añadir otra vista
        val btnForja = findViewById<Button>(R.id.btnForja)

        btnForja.setOnClickListener {
            startActivity(Intent(this, CreadorPersonajeActivity::class.java))
        }
        //

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Rivendell", "La Comunidad comienza su viaje")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Rivendell", "La Comunidad continúa su viaje")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Rivendell", "La Comunidad hace una pausa en el camino")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Rivendell", "La Comunidad abandona temporalmente el camino")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Rivendell", "El viaje de la Comunidad terminó")
    }
}
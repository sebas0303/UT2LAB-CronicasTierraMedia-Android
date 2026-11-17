package com.example.cronicastierramedia

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreadorPersonajeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creador_personaje)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val spRaza = findViewById<Spinner>(R.id.spRaza)
        val rgFaccion = findViewById<RadioGroup>(R.id.rgFaccion)
        val cbSigilo = findViewById<CheckBox>(R.id.cbSigilo)
        val cbEspada = findViewById<CheckBox>(R.id.cbEspada)
        val btnRegistro = findViewById<ImageButton>(R.id.btnRegistro)

        val registroEnLogcat: (String) -> Unit = { estructura ->
            Log.d("ForjaHeroe", estructura)
        }

        btnRegistro.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val raza = spRaza.selectedItem.toString()
            val faccion = findViewById<RadioButton>(rgFaccion.checkedRadioButtonId).text
            val habilidades = listOf(cbSigilo, cbEspada)
                .filter { it.isChecked }
                .joinToString(", ") { it.text }
                .ifEmpty { "ninguna" }

            Toast.makeText(
                this,
                "$nombre\nRaza: $raza\nFacción: $faccion\nHabilidades: $habilidades",
                Toast.LENGTH_LONG
            ).show()

            registroEnLogcat("Personaje(nombre=$nombre, raza=$raza, faccion=$faccion, habilidades=[$habilidades])")
        }
    }
}
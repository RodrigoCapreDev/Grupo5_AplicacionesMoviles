package com.grupo5.app1

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BienvenidaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        // Configuración de bienvenida
        val nombre = intent.getStringExtra("NOMBRE") ?: "usuario"
        val textView = findViewById<TextView>(R.id.tvBienvenida)
        textView.text = "¡Bienvenido, $nombre!"

        // Obtener la radioGroup para plataforma
        val radioGroupPlataforma = findViewById<RadioGroup>(R.id.radioGroupPlataforma)
        val tvPlataformaSeleccionada = findViewById<TextView>(R.id.tvPlataformaSeleccionada)

        // Configuración de preferencia "Otra"
        val checkOtra = findViewById<CheckBox>(R.id.checkOtra)
        val editOtraPreferencia = findViewById<EditText>(R.id.editOtraPreferencia)

        // Mostrar plataforma seleccionada
        radioGroupPlataforma.setOnCheckedChangeListener { _, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)
            val platform = selectedRadioButton.text.toString()
            tvPlataformaSeleccionada.text = "Plataforma seleccionada: $platform"
            tvPlataformaSeleccionada.visibility = View.VISIBLE
        }

        // Mostrar campo de "Otra" preferencia si se selecciona
        checkOtra.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editOtraPreferencia.visibility = View.VISIBLE
            } else {
                editOtraPreferencia.visibility = View.GONE
            }
        }
    }
}

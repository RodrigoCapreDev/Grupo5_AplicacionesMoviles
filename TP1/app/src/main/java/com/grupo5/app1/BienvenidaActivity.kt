package com.grupo5.app1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class BienvenidaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val ivLogout = findViewById<ImageView>(R.id.ivLogout)
        ivLogout.setOnClickListener {
            finish()
        }

        // Bienvenida con nombre
        val nombre = intent.getStringExtra("NOMBRE") ?: "usuario"
        val tvBienvenida = findViewById<TextView>(R.id.tvBienvenida)
        tvBienvenida.text = "¡Bienvenido, $nombre!"

        // Elementos de plataforma
        val radioGroupPlataforma = findViewById<RadioGroup>(R.id.radioGroupPlataforma)
        val imgPlataforma = findViewById<ImageView>(R.id.imgPlataforma)

        // Elementos de preferencias
        val checkOtra = findViewById<CheckBox>(R.id.checkOtra)
        val editOtraPreferencia = findViewById<EditText>(R.id.editOtraPreferencia)

        radioGroupPlataforma.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioAndroid -> {
                    imgPlataforma.setImageResource(R.drawable.logo_android) // Asegurate de tener esta imagen en res/drawable
                    imgPlataforma.visibility = View.VISIBLE
                }
                R.id.radioIOS -> {
                    imgPlataforma.setImageResource(R.drawable.logo_ios) // También esta imagen
                    imgPlataforma.visibility = View.VISIBLE
                }
            }
        }


        // Mostrar campo adicional si se selecciona "Otra"
        checkOtra.setOnCheckedChangeListener { _, isChecked ->
            editOtraPreferencia.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
    }
}

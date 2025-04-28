package com.grupo5.app1

import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
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

        val nombre = intent.getStringExtra("NOMBRE") ?: "usuario"
        val tvBienvenida = findViewById<TextView>(R.id.tvBienvenida)
        tvBienvenida.text = "¡Bienvenido, $nombre!"

        val radioGroupPlataforma = findViewById<RadioGroup>(R.id.radioGroupPlataforma)
        val imgPlataforma = findViewById<ImageView>(R.id.imgPlataforma)

        val checkOtra = findViewById<CheckBox>(R.id.checkOtra)
        val editOtraPreferencia = findViewById<EditText>(R.id.editOtraPreferencia)

        val btnSaveChanges = findViewById<Button>(R.id.btnSaveChanges)

        radioGroupPlataforma.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioAndroid -> {
                    imgPlataforma.setImageResource(R.drawable.logo_android)
                    mostrarImagenAnimada(imgPlataforma)
                }
                R.id.radioIOS -> {
                    imgPlataforma.setImageResource(R.drawable.logo_ios)
                    mostrarImagenAnimada(imgPlataforma)
                }
            }
        }

        checkOtra.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editOtraPreferencia.animarMostrar()
            } else {
                editOtraPreferencia.animarOcultar()
            }
        }

        btnSaveChanges.setOnClickListener {
            btnSaveChanges.animarVista()
            Toast.makeText(this, "Información guardada correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mostrarImagenAnimada(imagen: ImageView) {
        imagen.apply {
            scaleX = 0f
            scaleY = 0f
            alpha = 0f
            visibility = View.VISIBLE
            animate()
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(700)
                .setInterpolator(OvershootInterpolator())
                .start()
        }
    }

}
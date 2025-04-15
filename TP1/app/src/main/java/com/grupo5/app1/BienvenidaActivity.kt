package com.grupo5.app1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BienvenidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val nombre = intent.getStringExtra("NOMBRE") ?: "usuario"
        val textView = findViewById<TextView>(R.id.tvBienvenida)
        textView.text = "¡Bienvenido, $nombre!"
    }
}

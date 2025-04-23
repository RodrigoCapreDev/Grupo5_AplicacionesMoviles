package com.grupo5.app1

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvRegister: TextView
    private lateinit var btnFb: ImageView
    private lateinit var btnGoogle: ImageView
    private lateinit var btnX: ImageView
    private lateinit var btnGithub: ImageView
    private lateinit var tvForgotPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsuario = findViewById(R.id.etUsuario)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvRegister = findViewById(R.id.tvRegister)
        btnFb = findViewById(R.id.icon1)
        btnGoogle = findViewById(R.id.icon2)
        btnX = findViewById(R.id.icon3)
        btnGithub = findViewById(R.id.icon4)

        btnLogin.setOnClickListener {
            val usuario = etUsuario.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (usuario == "Juan Torres" && password == "1234utn") {
                val intent = Intent(this, BienvenidaActivity::class.java)
                intent.putExtra("NOMBRE", usuario)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        tvForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnFb.setOnClickListener {
            Toast.makeText(this, "No disponible nunca", Toast.LENGTH_SHORT).show()
        }
        btnGoogle.setOnClickListener {
            Toast.makeText(this, "No disponible nunca", Toast.LENGTH_SHORT).show()
        }
        btnX.setOnClickListener {
            Toast.makeText(this, "No disponible nunca", Toast.LENGTH_SHORT).show()
        }
        btnGithub.setOnClickListener {
            Toast.makeText(this, "No disponible nunca", Toast.LENGTH_SHORT).show()
        }
    }
}
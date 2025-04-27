package com.grupo5.app1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.ImageView
import android.widget.Button
import android.widget.Toast
import android.util.Patterns


class RegisterActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etRepeatPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etNombre = findViewById(R.id.etNombre)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etRepeatPassword = findViewById(R.id.etRepeatPassword)
        btnRegister = findViewById(R.id.btnRegister)
        ivBack = findViewById(R.id.ivBack)

        ivBack.setOnClickListener {
            finish()
        }
        btnRegister.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val repeatPassword = etRepeatPassword.text.toString()
            if (nombre.isEmpty()) {
                etNombre.error = "Ingrese su nombre"
                etNombre.requestFocus()
                return@setOnClickListener
            }
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Ingrese un email válido"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                etPassword.error = "Ingrese una contraseña"
                etPassword.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 6) {
                etPassword.error = "La contraseña debe tener al menos 6 caracteres"
                etPassword.requestFocus()
                return@setOnClickListener
            }
            if (repeatPassword.isEmpty()) {
                etRepeatPassword.error = "Repita la contraseña"
                etRepeatPassword.requestFocus()
                return@setOnClickListener
            }
            if (password != repeatPassword) {
                etRepeatPassword.error = "Las contraseñas no coinciden"
                etRepeatPassword.requestFocus()
                return@setOnClickListener
            }

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

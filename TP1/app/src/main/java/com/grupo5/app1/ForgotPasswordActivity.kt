package com.grupo5.app1

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var btnSend: Button
    private lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        etEmail = findViewById(R.id.etEmail)
        btnSend = findViewById(R.id.btnSend)
        ivBack = findViewById(R.id.ivBack)

        ivBack.setOnClickListener {
            finish()
        }
        btnSend.setOnClickListener {
            btnSend.animarVista()
            val email = etEmail.text.toString().trim()
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Ingrese un email válido"
                etEmail.requestFocus()
            } else {
                Toast.makeText(this, "Verifique su bandeja de entrada", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}


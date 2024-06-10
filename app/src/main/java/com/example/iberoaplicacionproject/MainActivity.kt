package com.example.iberoaplicacionproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    /*Activity main solo tendra funciones para redirigir al usuario*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Primero esta el boton para registrarse en caso de no tener una cuenta creada*/
        val signUpButton = findViewById<Button>(R.id.buttonSignUp)
        signUpButton.setOnClickListener{
            val intentUp: Intent = Intent(this, SignUpActivity:: class.java)
            startActivity(intentUp)
        }
        /*Y el boton para iniciar sesion que por ahora el modulo esta en espera*/
        val signInButton = findViewById<Button>(R.id.buttonSignIn)
        signInButton.setOnClickListener{
            val intentOn: Intent = Intent(this, IngresoCliente:: class.java)
            startActivity(intentOn)
        }
    }
}
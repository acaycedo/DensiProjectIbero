package com.example.iberoaplicacionproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView


class SignUpActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_registrocliente)
            val usernameEditText = findViewById<EditText>(R.id.editUserText)
            val emailEditText = findViewById<EditText>(R.id.editCorreoText)
            val passwordEditText = findViewById<EditText>(R.id.textPassEdit)
            val signUpButton = findViewById<Button>(R.id.buttonSignUp)

            signUpButton.setOnClickListener{
                val username=usernameEditText.text.toString()
                val email=passwordEditText.text.toString()
                val password=passwordEditText.text.toString()
                finish()
            }
            val signInButton = findViewById<Button>(R.id.buttonSignIn)
            signInButton.setOnClickListener{
                val intent: Intent = Intent(this, LoginActivity:: class.java)
                startActivity(intent)
            }
            val imageButtonBack= findViewById<ImageView>(R.id.backMain)
            imageButtonBack.setOnClickListener{
                val intent: Intent = Intent(this, MainActivity:: class.java)
                startActivity(intent)
            }
    }
}
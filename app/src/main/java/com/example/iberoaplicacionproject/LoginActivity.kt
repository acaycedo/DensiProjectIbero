package com.example.iberoaplicacionproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logueocliente)
        val usernameEditText = findViewById<EditText>(R.id.textUserEdit)
        val passwordEditText = findViewById<EditText>(R.id.textPassEdit)


        val signInButton = findViewById<Button>(R.id.buttonSignIn)
        signInButton.setOnClickListener{
            val username=usernameEditText.text.toString()
            val password=passwordEditText.text.toString()
            var uservalid="andres"
            var passvalid="12345"

            if (username == uservalid && password==passvalid){
                val intent: Intent = Intent(this, ConversionActivity:: class.java)
                startActivity(intent)
            }
        }
        val signUpButton = findViewById<Button>(R.id.buttonSignUp)
        signUpButton.setOnClickListener{
            val intent: Intent = Intent(this, SignUpActivity:: class.java)
            startActivity(intent)
        }
        val imageButtonBack= findViewById<ImageButton>(R.id.imageButtonBack)
        imageButtonBack.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }


    }
}
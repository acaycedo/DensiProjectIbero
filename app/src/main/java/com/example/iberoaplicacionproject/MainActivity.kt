package com.example.iberoaplicacionproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUpButton = findViewById<Button>(R.id.buttonSignUp)
        signUpButton.setOnClickListener{
            val intent: Intent = Intent(this, SignUpActivity:: class.java)
            startActivity(intent)
        }
        val signInButton = findViewById<Button>(R.id.buttonSignIn)
        signInButton.setOnClickListener{
            val intent: Intent = Intent(this, LoginActivity:: class.java)
            startActivity(intent)
        }
    }
}
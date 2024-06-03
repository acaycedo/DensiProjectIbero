package com.example.iberoaplicacionproject

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class UsuarioActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)
        val backButton = findViewById<ImageButton>(R.id.imageButton)
        backButton.setOnClickListener{
            val intent: Intent = Intent(this, ConversionActivity:: class.java)
            startActivity(intent)
        }

    }

}
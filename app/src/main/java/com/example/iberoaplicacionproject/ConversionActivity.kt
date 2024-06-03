package com.example.iberoaplicacionproject

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ConversionActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)

        val imageButtonBack= findViewById<ImageButton>(R.id.imageButtonBack)
        imageButtonBack.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }
        val imageButtonPerfil= findViewById<ImageView>(R.id.buttonPerfil)
        imageButtonPerfil.setOnClickListener{
            val intent: Intent = Intent(this, ConversionActivity:: class.java)
            startActivity(intent)
        }

    }

}
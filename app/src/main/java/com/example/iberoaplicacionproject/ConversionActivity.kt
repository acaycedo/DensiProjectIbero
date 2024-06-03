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
        /*Mas de lo mismo, aca solo existen dos botones funcionales que son los de
        cerrar la sesion o entrar al perfil del usuario para actualizar datos*/
        val imageButtonBack= findViewById<ImageButton>(R.id.imageButtonBack)
        imageButtonBack.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }
        val imageButtonPerfil= findViewById<ImageView>(R.id.buttonPerfil)
        imageButtonPerfil.setOnClickListener{
            val intent: Intent = Intent(this, UsuarioActivity:: class.java)
            startActivity(intent)
        }


    }

}
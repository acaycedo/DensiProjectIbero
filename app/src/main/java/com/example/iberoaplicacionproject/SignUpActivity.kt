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
    /*Se crea una funcion para traer el contenido del layout de activity_registrocliente */
    setContentView(R.layout.activity_registrocliente)

        /*Se toma la informacion recogida de los diferentes imput y botones*/
    val usernameEditText = findViewById<EditText>(R.id.editUserText)
    val emailEditText = findViewById<EditText>(R.id.editCorreoText)
    val passwordEditText = findViewById<EditText>(R.id.textPassEdit)
    val signUpButton = findViewById<Button>(R.id.buttonSignUp)
        /*Se crea un evento si da click al boton de registrarse tomara los valores del imput, los almacena en variables y los convierte a string*/
    signUpButton.setOnClickListener{
        val username=usernameEditText.text.toString()
        val email=passwordEditText.text.toString()
        val password=passwordEditText.text.toString()
        finish()
    }
        /*Se crea una variable que almacena la info obtenida del boton de iniciar sesion*/
    val signInButton = findViewById<Button>(R.id.buttonSignIn)
        /*Se crea un evento al momento de dar click al boton*/
    signInButton.setOnClickListener{
        /*Se captura el intento para luego traer el layout de login*/
        val intent: Intent = Intent(this, LoginActivity:: class.java)
        startActivity(intent)
    }
        /*Se captura la interaccion con la ImageView que es usado para retroceder*/
    val imageButtonBack= findViewById<ImageView>(R.id.backMain)
        /*Se crear un evento cuando dan click a la image*/
    imageButtonBack.setOnClickListener{
        /* captura el intento y trae el layout de MainActivity o el menu de inico*/
        val intent: Intent = Intent(this, MainActivity:: class.java)
        startActivity(intent)
    }
}
}
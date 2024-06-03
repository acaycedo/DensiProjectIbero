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
        /*Se crea una funcion para traer el contenido del layout de activity_logueocliente */
        setContentView(R.layout.activity_logueocliente)
        /* Se trae y se guarda la informacion de los imput de iniciar sesion.*/
        val usernameEditText = findViewById<EditText>(R.id.textUserEdit)
        val passwordEditText = findViewById<EditText>(R.id.textPassEdit)

        /*se trae y se guarda lainfo que capte el boton de iniciar sesion */
        val signInButton = findViewById<Button>(R.id.buttonSignIn)

        /*al momento de dar click tomara las variables las pasara a string*/
        signInButton.setOnClickListener{
            val username=usernameEditText.text.toString()
            val password=passwordEditText.text.toString()
            /*Se crea dos variables con los datos de iniciar sesion*/
            var uservalid="andres"
            var passvalid="12345"
            /*Si la variable creada coincide con los valores almacenados en los imput del login dara acceso al usuario*/
            if (username == uservalid && password==passvalid){
                /*Una vez verificado traera el layout de conversion que es solo para usuarios admitidos*/
                val intent: Intent = Intent(this, ConversionActivity:: class.java)
                startActivity(intent)
            }
        }
        /*En caso de no tener cuenta existe el boton signUp que solo tiene como evento un click que lo devuelve al formulario de registrarse*/
        val signUpButton = findViewById<Button>(R.id.buttonSignUp)
        signUpButton.setOnClickListener{
            val intent: Intent = Intent(this, SignUpActivity:: class.java)
            startActivity(intent)
        }
        /*Aca existe un imageButton que quise cambiar para ver o medir la diferencia entre imageView y un ImageButton*/
        val imageButtonBack= findViewById<ImageButton>(R.id.imageButtonBack)
        imageButtonBack.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }


    }
}
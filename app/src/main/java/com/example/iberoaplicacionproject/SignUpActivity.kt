package com.example.iberoaplicacionproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth


class SignUpActivity: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    /*Se crea una funcion para traer el contenido del layout de activity_registrocliente */
    setContentView(R.layout.activity_registrocliente)
        setup()
        /*Se crea una variable que almacena la info obtenida del boton de iniciar sesion*/
    val signInButton = findViewById<Button>(R.id.buttonSignIn)
        /*Se crea un evento al momento de dar click al boton*/
    signInButton.setOnClickListener{
        /*Se captura el intento para luego traer el layout de login*/
        val intent: Intent = Intent(this, IngresoCliente:: class.java)
        startActivity(intent)
    }
        /*Se captura la interaccion con la ImageView que es usado para retroceder*/
    val imageButtonBack= findViewById<ImageView>(R.id.backMain)
        /*Se crear un evento cuando dan click a la image*/
    imageButtonBack.setOnClickListener {
        /* captura el intento y trae el layout de MainActivity o el menu de inico*/
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
    private fun setup(){
        val buttonSign = findViewById<Button>(R.id.buttonSignUp)
        val correoEditText = findViewById<EditText>(R.id.editCorreoText)
        val passwordEditText = findViewById<EditText>(R.id.textPassEdit)
        buttonSign.setOnClickListener{
            if (correoEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(correoEditText.text.toString(),passwordEditText.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        showConversion(it.result?.user?.email?:"", ProviderType.BASIC)
                    }else{
                        showAlert()
                    }
                }
            }
        }

    }
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error de autenticación")
        builder.setPositiveButton("Aceptar",null)
        val dialog:AlertDialog=builder.create()
        dialog.show()
    }

    private fun showConversion(email: String, provider:ProviderType){
        val homeIntent = Intent(this, ConversionActivity::class.java).apply {
            putExtra("email",email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)

    }
}
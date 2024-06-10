package com.example.iberoaplicacionproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class IngresoCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_cliente)
        setup()

    }
    private fun setup(){
        val buttonSign = findViewById<Button>(R.id.buttonSignIn)
        val correoEditText = findViewById<EditText>(R.id.editCorreoText)
        val passwordEditText = findViewById<EditText>(R.id.textPassEdit)
        buttonSign.setOnClickListener{
            if (correoEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(correoEditText.text.toString(),passwordEditText.text.toString()).addOnCompleteListener{
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
        val dialog: AlertDialog =builder.create()
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
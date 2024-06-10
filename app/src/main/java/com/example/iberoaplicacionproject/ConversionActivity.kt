package com.example.iberoaplicacionproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ConversionActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)
        calculo()
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
    private fun calculo(){
        val contentOrg = findViewById<EditText>(R.id.textConvertOriginal)
        val densidadDest = findViewById<EditText>(R.id.densidadAConvertir)
        val buttonConv = findViewById<Button>(R.id.buttonConvert)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonConv.setOnClickListener {
            if (densidadDest.text.isNotEmpty()) {
                val valor1 = densidadDest.text.toString().toDoubleOrNull()
                val gramoPorOnza = 28.3495
                if (valor1!= null){
                    val result = valor1 * gramoPorOnza
                    textViewResult.text="La onza equivale a: $gramoPorOnza por lo tanto da: $result gr"
                }else{
                    textViewResult.text = "Por favor, ingrese números válidos."
                }
            }else{
                showAlert()
            }
        }
    }
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("No se ha detectado datos a convertir")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }

}
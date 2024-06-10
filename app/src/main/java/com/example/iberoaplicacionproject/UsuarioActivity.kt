package com.example.iberoaplicacionproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

enum class ProviderType {
    BASIC
}
class UsuarioActivity: AppCompatActivity() {
    //private val db= FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)
        //traer correo para colocarlo como usuario
        val bundle:Bundle? = intent.extras
        val email:String? = bundle?.getString("email")
        val provider:String? = bundle?.getString("provider")
        //actualizarUser(email?:"",provider?:"")
        //FUNCION SETUP
        setup(email?:"",provider?:"")

        //Boton para regresar a conversion
        val backButton = findViewById<ImageButton>(R.id.imageButton)
        backButton.setOnClickListener{
            val intent: Intent = Intent(this, ConversionActivity:: class.java)
            startActivity(intent)
        }
        //AGREGAR USUARIO
        val btnAgregarUsuario = findViewById<Button>(R.id.actualizarButton)
        btnAgregarUsuario.setOnClickListener{
            val direccion = findViewById<EditText>(R.id.textViewDireccion)
            val celular = findViewById<EditText>(R.id.textViewCelular)
            direccion.text
            celular.text

            val nuevoUsuario = Usuario(direccion.toString(), celular.toString())

            val usuarioFinal = ActualizarUsuario() // Aquí deberías tener tu gestor de productos

            usuarioFinal.agregarUsuario(nuevoUsuario) { exito ->
                if (exito) {
                    Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error al tratar de actualizar datos", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
    private fun setup(email: String,provider: String){
        val modText= findViewById<TextView>(R.id.textViewUser)
        val logOut = findViewById<Button>(R.id.cerrarSesion)
        modText.text="Correo: $email"
        logOut.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }

    }
    /*private fun actualizarUser(email: String,provider: String){
        val actualizarButton = findViewById<Button>(R.id.actualizarButton)
        val direcicon= findViewById<EditText>(R.id.textViewDireccion)
        val celular= findViewById<EditText>(R.id.textViewCelular)
        db.collection("users").document(email).set(
            hashMapOf("provider" to provider,
                "address" to direcicon.text.toString(),
                "phone" to celular.text.toString())
        )

    }
     */
    private fun borrarUser(email: String,provider: String){
        val actualizarButton = findViewById<Button>(R.id.actualizarButton)


    }
    private fun traerUser(email: String,provider: String){
        val actualizarButton = findViewById<Button>(R.id.actualizarButton)


    }




}
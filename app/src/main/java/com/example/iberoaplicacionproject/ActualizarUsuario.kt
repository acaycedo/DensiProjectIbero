package com.example.iberoaplicacionproject

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ActualizarUsuario {

        private val database: DatabaseReference by lazy {
            FirebaseDatabase.getInstance().reference.child("usuarios")
        }

        fun agregarUsuario(usuario: Usuario, callback: (Boolean) -> Unit) {
            val id = database.push().key // Generar un nuevo ID para el usuario al ser autoincrementable
            if (id != null) {
                database.child(id).setValue(usuario)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            callback(true)
                        } else {
                            callback(false)
                        }
                    }
            } else {
                callback(false)
            }
        }

}
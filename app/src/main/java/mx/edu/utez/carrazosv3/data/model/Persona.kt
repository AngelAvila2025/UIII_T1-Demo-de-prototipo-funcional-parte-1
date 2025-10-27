package mx.edu.utez.carrazosv3.data.model

import androidx.annotation.DrawableRes

data class Persona(
    val id: Int,
    val nombre: String,
    val correo: String,
    val telefono: String,
    @DrawableRes val imagen: Int
)

//No es necesario hacer constructor ni getters ni setters
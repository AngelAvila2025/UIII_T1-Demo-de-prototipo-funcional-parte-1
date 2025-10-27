package mx.edu.utez.carrazosv3.data.model

import androidx.annotation.DrawableRes
import mx.edu.utez.carrazosv3.R

data class User(
    val id: Int,
    @DrawableRes val imagen: Int = R.drawable.femaleprofile,
    val nombre: String,
    val correo: String,
    val telefono: String,
    val sexo: Int
)

//No es necesario hacer constructores
//getters ni setters
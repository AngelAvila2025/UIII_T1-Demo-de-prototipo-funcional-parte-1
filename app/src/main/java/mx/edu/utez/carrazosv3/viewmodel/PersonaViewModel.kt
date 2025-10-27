package mx.edu.utez.carrazosv3.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import mx.edu.utez.carrazosv3.R
import mx.edu.utez.carrazosv3.data.model.Persona

class PersonaViewModel: ViewModel() {

    //Vamos a usar algo conocido como mutableStateFLOW
    val _personas = MutableStateFlow<List<Persona>>(emptyList())
    val personas: StateFlow<List<Persona>> = _personas

    init {
        _personas.value = listOf(
            Persona(
                1,
                "Marlen",
                "marlen@gmail.com",
                "7771836233",
                R.drawable.femaleprofile
            ),
            Persona(
                2,
                "Angel",
                "angel@gmail.com",
                "7771836233",
                R.drawable.maleprofile
            ),
            Persona(
                3,
                "Daniel",
                "daniel@gmail.com",
                "7771836233",
                R.drawable.maleprofile
            ),
            Persona(
                4,
                "Mitzi",
                "mitzi@gmail.com",
                "7771836233",
                R.drawable.femaleprofile
            ),
            Persona(
                5,
                "Alice",
                "alice@gmail.com",
                "7771836233",
                R.drawable.femaleprofile
            ),
            Persona(
                6,
                "Andrea",
                "andrea@gmail.com",
                "7771836233",
                R.drawable.femaleprofile
            ),
        )
    }

    fun clickPersona(persona: Persona){
        println("Has hecho click en: ${persona.nombre}")
    }

}
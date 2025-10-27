package mx.edu.utez.carrazosv3.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.carrazosv3.R
import mx.edu.utez.carrazosv3.data.model.Persona
import mx.edu.utez.carrazosv3.ui.theme.CalculadoraMVVMTheme

@Composable
fun PersonaList(lista: List<Persona>, x: (Persona) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        //Iterar la lista en Java es con foreach
        //Pero en kotlin vamos a ocupar una funcion items
        items(items = lista, key = {it.id} ) {persona ->
            PersonaCard(persona) { x(persona) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonaList(){
    val lista = listOf(
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
    CalculadoraMVVMTheme {
        PersonaList(lista) { }
    }
}
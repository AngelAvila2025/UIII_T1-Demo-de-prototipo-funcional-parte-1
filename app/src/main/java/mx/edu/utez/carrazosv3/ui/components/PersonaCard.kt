package mx.edu.utez.carrazosv3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import mx.edu.utez.carrazosv3.R
import mx.edu.utez.carrazosv3.data.model.Persona
import mx.edu.utez.carrazosv3.ui.theme.CalculadoraMVVMTheme

//Representa una sola persona
@Composable
fun PersonaCard(p: Persona, x: (Persona) -> Unit){
    Column{
        Card (
            modifier = Modifier.clickable{x(p)}
        ) {
            Row (verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(p.imagen),
                    contentDescription = "imagen de la persona"
                )
                Column {
                    Text(text = p.nombre, fontWeight = FontWeight.Bold)
                    Text(text = p.correo)
                    Text(text = p.telefono)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonaCard(){
    val p = Persona(
        1,
        "Marlen",
        "marlen@gmail.com",
        "7771836233",
        R.drawable.femaleprofile
    )
    CalculadoraMVVMTheme {
        PersonaCard(p) { }
    }
}
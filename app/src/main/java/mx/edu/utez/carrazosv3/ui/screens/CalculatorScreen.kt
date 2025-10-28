package mx.edu.utez.carrazosv3.ui.screens


import NumberInputField
import Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.edu.utez.carrazosv3.ui.components.buttons.CalculatorButton
import mx.edu.utez.carrazosv3.ui.components.texts.Label
import mx.edu.utez.carrazosv3.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Title("Bienvenido a la calculadora")

        Label("Ingrese 2 numeros y posteriormente un operador")

        NumberInputField("Número 1", viewModel.numero1)
        NumberInputField("Número 1", viewModel.numero2)

        Row (horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CalculatorButton("+") {
                viewModel.suma()
            }
            CalculatorButton("-") { }
            CalculatorButton("^") { }
        }

        Row (horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CalculatorButton("*") { }
            CalculatorButton("/") { }
            CalculatorButton("%") { }
        }

        if (viewModel.resultado.value.isNotEmpty()) {
            Text(
                text = viewModel.resultado.value,
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
package mx.edu.utez.carrazosv3.ui.screens

import Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.edu.utez.carrazosv3.ui.components.misc.Incubadora
import mx.edu.utez.carrazosv3.ui.components.texts.Label
import mx.edu.utez.carrazosv3.viewmodel.IncubadoraViewModel

@Composable
fun IncubadoraScreen(viewModel: IncubadoraViewModel = androidx.lifecycle.viewmodel.compose.viewModel(), navController: NavController) {
    val puntos = viewModel.puntos.value
    val restantes = viewModel.avesRestantes()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Title(text = "Puntos: $puntos")
        Spacer(modifier = Modifier.height(16.dp))
        Incubadora(viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        Label(text = "Aves restantes: $restantes")
    }
}










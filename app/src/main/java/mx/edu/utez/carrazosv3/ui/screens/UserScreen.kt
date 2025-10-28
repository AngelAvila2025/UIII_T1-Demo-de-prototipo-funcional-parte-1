package mx.edu.utez.carrazosv3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UserScreen(navController: NavController, userName: String = "Juan Pérez", userEmail: String = "juanperez@example.com") {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Perfil de Usuario", color = Color.White, fontSize = 26.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Nombre: $userName", color = Color.White, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Correo: $userEmail", color = Color.White, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("login") }) {
            Text(text = "Cerrar sesión", color = Color.Black)
        }
    }
}

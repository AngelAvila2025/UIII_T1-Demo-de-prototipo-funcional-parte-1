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
fun CartScreen(navController: NavController, itemsInCart: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Carrito de Compras", color = Color.White, fontSize = 26.sp)
        Spacer(modifier = Modifier.height(16.dp))

        if (itemsInCart.isEmpty()) {
            Text(text = "Tu carrito está vacío.", color = Color.White, fontSize = 18.sp)
        } else {
            itemsInCart.forEach { item ->
                Text(text = "• $item", color = Color.White, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Proceso de pago */ }) {
                Text("Proceder al pago", color = Color.Black)
            }
        }
    }
}

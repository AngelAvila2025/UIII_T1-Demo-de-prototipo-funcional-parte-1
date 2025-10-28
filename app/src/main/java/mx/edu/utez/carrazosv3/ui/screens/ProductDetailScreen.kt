package mx.edu.utez.carrazosv3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import mx.edu.utez.carrazosv3.viewmodel.MenuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController, backStackEntry: NavBackStackEntry, viewModel: MenuViewModel) {
    val nombre = URLDecoder.decode(backStackEntry.arguments?.getString("nombre") ?: "", StandardCharsets.UTF_8.toString())
    val descripcion = URLDecoder.decode(backStackEntry.arguments?.getString("descripcion") ?: "", StandardCharsets.UTF_8.toString())
    val precio = backStackEntry.arguments?.getString("precio")?.toDoubleOrNull() ?: 0.0
    val imagen = backStackEntry.arguments?.getString("imagen")?.toIntOrNull() ?: 0

    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                title = { Text(nombre, color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.Home, contentDescription = "Volver", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = imagen),
                contentDescription = nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Text(nombre, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(descripcion, color = Color.LightGray, fontSize = 16.sp)
            Text("Precio: $${precio}", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Button(
                onClick = {
                    viewModel.addToCart(
                        mx.edu.utez.carrazosv3.data.model.Carro(nombre, descripcion, precio, imagen)
                    )
                    navController.navigate("cart")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Añadir al carrito", color = Color.Black)
            }
        }
    }
}

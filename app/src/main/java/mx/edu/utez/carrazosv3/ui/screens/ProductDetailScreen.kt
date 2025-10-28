package mx.edu.utez.carrazosv3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mx.edu.utez.carrazosv3.data.model.Carro
import mx.edu.utez.carrazosv3.viewmodel.MenuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController, carro: Carro, viewModel: MenuViewModel) {
    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                title = { Text(carro.nombre, color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.Black)
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = carro.imagen),
                contentDescription = carro.nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            Text(carro.nombre, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(carro.descripcion, color = Color.LightGray, fontSize = 16.sp)
            Text("Precio: $${carro.precio}", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Button(
                onClick = {
                    viewModel.addToCart(carro)
                    navController.navigate("cart")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Añadir al carrito", color = Color.Black)
            }
        }
    }
}

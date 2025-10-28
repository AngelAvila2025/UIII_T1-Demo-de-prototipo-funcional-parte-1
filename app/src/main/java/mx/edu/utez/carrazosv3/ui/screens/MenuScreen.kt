package mx.edu.utez.carrazosv3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import mx.edu.utez.carrazosv3.R
import mx.edu.utez.carrazosv3.data.model.Carro
import mx.edu.utez.carrazosv3.viewmodel.MenuViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun AutoCard(carro: Carro, viewModel: MenuViewModel, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = carro.imagen),
                contentDescription = carro.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clickable {
                        val nombre = URLEncoder.encode(carro.nombre, StandardCharsets.UTF_8.toString())
                        val desc = URLEncoder.encode(carro.descripcion, StandardCharsets.UTF_8.toString())
                        navController.navigate("productDetail/$nombre/$desc/${carro.precio}/${carro.imagen}")
                    },
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(carro.nombre, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(carro.descripcion, color = Color.LightGray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("$${carro.precio}", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)

            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Button(
                    onClick = { viewModel.goToCalculator(navController) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Comprar", color = Color.Black)
                }

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
}

@Composable
fun MenuScreen(viewModel: MenuViewModel, navController: NavController) {
    val autos = listOf(
        Carro("Mazda 3 2016 2.5", "Excelente estado, transmisión automática, 60,000 km.", 158000.00, R.drawable.pnn),
        Carro("Toyota Corolla 2019", "Único dueño, motor eficiente, interiores de lujo.", 225000.00, R.drawable.corrolla),
        Carro("Honda Civic 2020", "Versión sport, todo eléctrico, poco uso.", 240000.00, R.drawable.civic)
    )

    Scaffold(
        bottomBar = { BottomNavBar(navController) },
        containerColor = Color.Black
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(padding)
                .padding(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Explora los mejores autos 🚗",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

            items(autos) { carro ->
                AutoCard(carro = carro, viewModel = viewModel, navController = navController)
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(containerColor = Color.Black) {
        NavigationBarItem(
            selected = currentRoute?.startsWith("home") == true,
            onClick = { navController.navigate("home") },
            icon = {
                Icon(Icons.Default.Home, contentDescription = "Inicio",
                    tint = if (currentRoute?.startsWith("home") == true) Color.White else Color.Gray)
            }
        )

        NavigationBarItem(
            selected = currentRoute?.startsWith("user") == true,
            onClick = { navController.navigate("user") },
            icon = {
                Icon(Icons.Default.Person, contentDescription = "Usuario",
                    tint = if (currentRoute?.startsWith("user") == true) Color.White else Color.Gray)
            }
        )

        NavigationBarItem(
            selected = currentRoute?.startsWith("cart") == true,
            onClick = { navController.navigate("cart") },
            icon = {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito",
                    tint = if (currentRoute?.startsWith("cart") == true) Color.White else Color.Gray)
            }
        )
    }
}

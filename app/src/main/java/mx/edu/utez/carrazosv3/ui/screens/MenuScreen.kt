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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mx.edu.utez.carrazosv3.viewmodel.MenuViewModel
import mx.edu.utez.carrazosv3.R
import mx.edu.utez.carrazosv3.data.model.Carro

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

            // Imagen clickeable (abre la vista de detalles o "ver más")
            Image(
                painter = painterResource(id = carro.imagen),
                contentDescription = carro.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color.DarkGray, RoundedCornerShape(8.dp))
                    .clickable { viewModel.goToUserList(navController) }, // Igual que el botón "ver más"
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = carro.nombre,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = carro.descripcion,
                color = Color(0xFFB0B0B0),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$${carro.precio}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Botones
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { viewModel.goToCalculator(navController) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Comprar", color = Color.Black)
                }

                // Botón cambiado a "Añadir al carrito"
                Button(
                    onClick = { viewModel.addToCart(carro) }, // Puedes crear este método en el ViewModel
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
        Carro("Mazda 3 2016 2.5", "Excelente estado, transmisión automática, 60,000 km.", 158000.00, R.drawable.polluelo),
        Carro("Toyota Corolla 2019", "Único dueño, motor eficiente, interiores de lujo.", 225000.00, R.drawable.polluelo),
        Carro("Honda Civic 2020", "Versión sport, todo eléctrico, poco uso.", 240000.00, R.drawable.polluelo)
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
                AutoCard(
                    carro = carro,
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavController) {
    NavigationBar(containerColor = Color.Black) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio", tint = Color.White) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("user") },
            icon = { Icon(Icons.Default.Person, contentDescription = "Usuario", tint = Color.White) }
        )
        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate("cart") },
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito", tint = Color.White) }
        )
    }
}

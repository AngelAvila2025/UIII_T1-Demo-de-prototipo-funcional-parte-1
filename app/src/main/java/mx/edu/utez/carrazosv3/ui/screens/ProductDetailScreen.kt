package mx.edu.utez.carrazosv3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import mx.edu.utez.carrazosv3.R
import mx.edu.utez.carrazosv3.data.model.Carro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController) {
    val carroEjemplo = Carro(
        "Mazda 3 2016 2.5",
        "Excelente estado, transmisión automática, 60,000 km. Ideal para ciudad y carretera.",
        158000.00,
        R.drawable.polluelo
    )

    val similares = listOf(
        Carro("Toyota Corolla 2019", "Motor eficiente, interiores de lujo.", 225000.00, R.drawable.polluelo),
        Carro("Honda Civic 2020", "Versión sport, poco uso.", 240000.00, R.drawable.polluelo),
        Carro("Nissan Sentra 2018", "Buen rendimiento, único dueño.", 175000.00, R.drawable.polluelo)
    )

    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                title = { Text("Detalles del Producto", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = carroEjemplo.imagen),
                contentDescription = carroEjemplo.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color.DarkGray, RoundedCornerShape(10.dp))
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = carroEjemplo.nombre,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = carroEjemplo.descripcion,
                color = Color(0xFFB0B0B0),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "$${carroEjemplo.precio}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /* Comprar ahora */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Comprar ahora", color = Color.Black)
                }

                Button(
                    onClick = { /* Añadir al carrito */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Añadir al carrito", color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Productos similares",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(similares) { similar ->
                    Card(
                        modifier = Modifier
                            .width(180.dp)
                            .clickable { /* Navegar a otro detalle */ },
                        colors = CardDefaults.cardColors(containerColor = Color.Black),
                        shape = RoundedCornerShape(10.dp),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = similar.imagen),
                                contentDescription = similar.nombre,
                                modifier = Modifier
                                    .height(100.dp)
                                    .fillMaxWidth()
                                    .background(Color.DarkGray, RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(similar.nombre, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text("$${similar.precio}", color = Color(0xFFB0B0B0), fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}

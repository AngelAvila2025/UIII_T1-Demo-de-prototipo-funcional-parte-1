package mx.edu.utez.carrazosv3.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import mx.edu.utez.carrazosv3.R
import mx.edu.utez.carrazosv3.data.model.Carro

class MenuViewModel : ViewModel() {
    val cartItems = mutableStateListOf<Carro>()

    // Lista de autos
    val carList = listOf(
        Carro("Mazda 3 2016 2.5", "Excelente estado, transmisión automática, 70,000 km, único dueño, factura original.", 158900.00, R.drawable.pnn),
        Carro("Toyota Corolla 2019", "Único dueño, motor eficiente, interiores de lujo, excelente estado.", 235000.00, R.drawable.corrolla),
        Carro("Honda Civic 2020", "Versión sport, todo eléctrico, poco uso, A/C, encendido de botón.", 245000.00, R.drawable.civic)
    )

    fun addToCart(carro: Carro) {
        if (!cartItems.contains(carro)) cartItems.add(carro)
    }
}

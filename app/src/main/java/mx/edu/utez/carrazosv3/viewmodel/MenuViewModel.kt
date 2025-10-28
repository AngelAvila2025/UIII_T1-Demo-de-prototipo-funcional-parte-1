package mx.edu.utez.carrazosv3.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import mx.edu.utez.carrazosv3.data.model.Carro

class MenuViewModel : ViewModel() {
    val cartItems = mutableStateListOf<Carro>()

    fun addToCart(carro: Carro) {
        if (!cartItems.contains(carro)) {
            cartItems.add(carro)
        }
    }

    fun goToCalculator(navController: NavController) {
        navController.navigate("cart")
    }
}

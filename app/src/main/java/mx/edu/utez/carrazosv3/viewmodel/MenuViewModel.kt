package mx.edu.utez.carrazosv3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import mx.edu.utez.carrazosv3.data.model.Carro

class MenuViewModel: ViewModel(){

    fun goToCalculator(navController: NavController){
        navController.navigate("calculator")
    }

    fun goToTicTacToe(navController: NavController){
        navController.navigate("tictactoe")
    }

    fun goToIncubadora(navController: NavController){
        navController.navigate("incubadora")
    }

    fun goToUserList(navController: NavController){
        navController.navigate("verUsuarios")
    }

    fun goToPersona(navController: NavController){
        navController.navigate("verPersona")
    }
    fun addToCart(carro: Carro) {
        // Aquí puedes implementar la lógica para agregar el auto al carrito
        println("${carro.nombre} añadido al carrito")
    }

}
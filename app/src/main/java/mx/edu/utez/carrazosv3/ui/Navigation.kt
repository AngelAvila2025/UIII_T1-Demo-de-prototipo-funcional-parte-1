package mx.edu.utez.carrazosv3.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import mx.edu.utez.carrazosv3.ui.screens.*
import mx.edu.utez.carrazosv3.viewmodel.LoginViewModel
import mx.edu.utez.carrazosv3.viewmodel.MenuViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val menuViewModel: MenuViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {

        // Login
        composable("login") {
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(viewModel = loginViewModel, navController = navController)
        }

        // Home / Menu
        composable("home") {
            MenuScreen(viewModel = menuViewModel, navController = navController)
        }

        // Registro
        composable("register") {
            RegisterScreen(navController = navController)
        }

        // Recuperar contraseña
        composable("forgot_password") {
            ForgotPasswordScreen(navController = navController)
        }

        // Carrito
        composable("cart") {
            CartScreen(navController, menuViewModel.cartItems.map { it.nombre })
        }

        // Usuario
        composable("user") {
            UserScreen(navController)
        }

        // Product Detail por índice
        composable(
            route = "productDetail/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            val carro = menuViewModel.carList[index]
            ProductDetailScreen(navController, carro, menuViewModel)
        }
    }
}

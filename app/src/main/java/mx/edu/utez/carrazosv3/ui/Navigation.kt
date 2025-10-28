package mx.edu.utez.carrazosv3.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import mx.edu.utez.carrazosv3.ui.screens.*
import mx.edu.utez.carrazosv3.viewmodel.LoginViewModel
import mx.edu.utez.carrazosv3.viewmodel.MenuViewModel


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val menuViewModel: MenuViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(viewModel = loginViewModel, navController = navController)
        }

        composable("home") {
            MenuScreen(viewModel = menuViewModel, navController = navController)
        }

        composable("forgot_password") { ForgotPasswordScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("cart") { CartScreen(navController, menuViewModel.cartItems.map { it.nombre }) }
        composable("user") { UserScreen(navController) }
    }
}

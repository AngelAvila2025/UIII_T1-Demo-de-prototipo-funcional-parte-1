package mx.edu.utez.carrazosv3.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.carrazosv3.ui.screens.*
import mx.edu.utez.carrazosv3.viewmodel.*
import mx.edu.utez.gato.viewmodel.LoginViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel()
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("forgot_password") { ForgotPasswordScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("home") { HomeScreen(navController) }

        composable("calculator") {
            val viewModel: CalculatorViewModel = viewModel()
            CalculatorScreen(viewModel = viewModel, navController = navController)
        }

        composable("tictactoe") {
            val viewModel: TicTacToeViewModel = viewModel()
            TicTacToeScreen(viewModel = viewModel, navController = navController)
        }

        composable("incubadora") {
            val viewModel: IncubadoraViewModel = viewModel()
            IncubadoraScreen(viewModel = viewModel, navController = navController)
        }

        composable("menu") {
            val viewModel: MenuViewModel = viewModel()
            MenuScreen(viewModel = viewModel, navController = navController)
        }

        composable("verUsuarios") {
            val viewModel: UserListViewModel = viewModel()
            UserScreen(viewModel, navController = navController)
        }

        composable("verPersona") {
            val viewModel: PersonaViewModel = viewModel()
            PersonaScreen(viewModel, navController = navController)
        }

        // Nueva pantalla de detalle de producto
        composable("productDetail") {
            ProductDetailScreen(navController = navController)
        }
    }
}

package mx.edu.utez.carrazosv3.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.carrazosv3.ui.screens.CalculatorScreen
import mx.edu.utez.carrazosv3.ui.screens.ForgotPasswordScreen
import mx.edu.utez.carrazosv3.ui.screens.HomeScreen
import mx.edu.utez.carrazosv3.ui.screens.IncubadoraScreen
import mx.edu.utez.carrazosv3.ui.screens.LoginScreen
import mx.edu.utez.carrazosv3.ui.screens.MenuScreen
import mx.edu.utez.carrazosv3.ui.screens.PersonaScreen
import mx.edu.utez.carrazosv3.ui.screens.RegisterScreen
import mx.edu.utez.carrazosv3.ui.screens.TicTacToeScreen
import mx.edu.utez.carrazosv3.ui.screens.UserScreen
import mx.edu.utez.carrazosv3.viewmodel.CalculatorViewModel
import mx.edu.utez.carrazosv3.viewmodel.IncubadoraViewModel
import mx.edu.utez.carrazosv3.viewmodel.MenuViewModel
import mx.edu.utez.carrazosv3.viewmodel.PersonaViewModel
import mx.edu.utez.carrazosv3.viewmodel.TicTacToeViewModel
import mx.edu.utez.carrazosv3.viewmodel.UserListViewModel
import mx.edu.utez.gato.viewmodel.LoginViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel() // instancia del ViewModel
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("forgot_password") { ForgotPasswordScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("calculator") {
            val viewModel: CalculatorViewModel = viewModel() // instancia del ViewModel
            CalculatorScreen(viewModel = viewModel, navController = navController)
        }
        composable("tictactoe") {
            val viewModel: TicTacToeViewModel = viewModel() // instancia del ViewModel
            TicTacToeScreen(viewModel = viewModel, navController = navController)
        }
        composable("incubadora") {
            val viewModel: IncubadoraViewModel = viewModel() // instancia del ViewModel
            IncubadoraScreen(viewModel = viewModel, navController = navController)
        }
        composable("menu") {
            val viewModel: MenuViewModel = viewModel() // instancia del ViewModel
            MenuScreen(viewModel = viewModel, navController = navController)
        }
        composable("verUsuarios"){
            val viewModel: UserListViewModel = viewModel()
            UserScreen(viewModel, navController=navController)
        }
        composable("verPersona"){
            val viewModel: PersonaViewModel = viewModel()
            PersonaScreen(viewModel, navController=navController)
        }
        //Nuevas rutas aca
    }
}
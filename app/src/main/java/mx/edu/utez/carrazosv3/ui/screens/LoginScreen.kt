package mx.edu.utez.carrazosv3.ui.screens

import PrimaryButton
import Title
import UserInputField
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.gato.viewmodel.LoginViewModel
import mx.edu.utez.carrazosv3.ui.components.inputs.PasswordField
import mx.edu.utez.carrazosv3.ui.components.texts.Link
import mx.edu.utez.carrazosv3.ui.theme.CalculadoraMVVMTheme

@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween // deja espacio entre contenido y botón inferior
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Logo circular
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color(0xFF3DDC84), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("UT", color = Color.White, style = MaterialTheme.typography.titleLarge)
            }

            Title("Aplicación\nMóvil")

            UserInputField(
                viewModel = viewModel,
                label = "Usuario"
            )

            PasswordField(
                viewModel = viewModel,
                label = "Contraseña"
            )

            if (viewModel.loginError.value.isNotEmpty()) {
                Text(
                    text = viewModel.loginError.value,
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Link("¿Has olvidado la contraseña?") {
                navController.navigate("forgot_password")
            }

            PrimaryButton("Iniciar sesión") {
                viewModel.login {
                    navController.navigate("menu") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            }

            Link("¿No tienes cuenta? Regístrate") {
                navController.navigate("register")
            }
        }

        // Botón colocado hasta abajo
        PrimaryButton("Regresar al login") {
            navController.navigate("login")
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    CalculadoraMVVMTheme {
        val navController = rememberNavController()
        val viewModel = LoginViewModel()

        LoginScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}

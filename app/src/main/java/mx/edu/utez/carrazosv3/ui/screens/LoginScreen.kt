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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.carrazosv3.ui.components.inputs.PasswordField
import mx.edu.utez.carrazosv3.ui.components.texts.Link
import mx.edu.utez.carrazosv3.ui.theme.CalculadoraMVVMTheme
import mx.edu.utez.gato.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Fondo negro
            .padding(horizontal = 30.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        // Círculo decorativo o logo temporal
        Box(
            modifier = Modifier
                .size(110.dp)
                .background(color = Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("C", color = Color.Black, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        }

        // Nombre de la app
        Text(
            text = "CARRAZOS",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )

        // Mensaje de bienvenida
        Text(
            text = "¡Bienvenido, usuario!",
            color = Color(0xFFB0B0B0),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Campo Usuario
        UserInputField(
            viewModel = viewModel,
            label = "Usuario"
        )

        // Campo Contraseña
        PasswordField(
            viewModel = viewModel,
            label = "Contraseña"
        )

        // Mensaje de error (si hay)
        if (viewModel.loginError.value.isNotEmpty()) {
            Text(
                text = viewModel.loginError.value,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        // Enlace recuperar contraseña
        Link("¿Olvidaste tu contraseña?") {
            navController.navigate("forgot_password")
        }

        // Botón de iniciar sesión
        PrimaryButton("Iniciar sesión") {
            viewModel.login {
                navController.navigate("menu") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }

        // Enlace registrar
        Link("¿No tienes cuenta? Regístrate") {
            navController.navigate("register")
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Frase final decorativa
        Text(
            text = "Conduce tu futuro con Carrazos 🚗",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light
        )
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    CalculadoraMVVMTheme {
        val navController = rememberNavController()
        val viewModel = LoginViewModel()
        LoginScreen(viewModel = viewModel, navController = navController)
    }
}

package mx.edu.utez.carrazosv3.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
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
import mx.edu.utez.carrazosv3.ui.components.buttons.PrimaryButton
import mx.edu.utez.carrazosv3.ui.components.inputs.PasswordField
import mx.edu.utez.carrazosv3.ui.components.inputs.UserInputField
import mx.edu.utez.carrazosv3.ui.components.texts.Link
import mx.edu.utez.carrazosv3.viewmodel.LoginViewModel


@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 30.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Box(
            modifier = Modifier
                .size(110.dp)
                .background(Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("C", color = Color.Black, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        }

        Text("CARRAZOS", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Text("¡Bienvenido, usuario!", color = Color(0xFFB0B0B0), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(20.dp))

        UserInputField(viewModel = viewModel, label = "Usuario")
        PasswordField(viewModel = viewModel, label = "Contraseña")

        if (viewModel.loginError.value.isNotEmpty()) {
            Text(viewModel.loginError.value, color = Color.Red)
        }

        Link("¿Olvidaste tu contraseña?") { navController.navigate("forgot_password") }

        PrimaryButton("Iniciar sesión") {
            viewModel.login {
                navController.navigate("home") { // ✅ ruta corregida
                    popUpTo("login") { inclusive = true }
                }
            }
        }

        Link("¿No tienes cuenta? Regístrate") { navController.navigate("register") }

        Spacer(modifier = Modifier.height(40.dp))
        Text("Conduce tu futuro con Carrazos 🚗", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Light)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    val viewModel = LoginViewModel()
    LoginScreen(viewModel = viewModel, navController = navController)
}

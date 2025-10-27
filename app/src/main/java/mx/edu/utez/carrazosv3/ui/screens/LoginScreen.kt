package mx.edu.utez.carrazosv3.ui.screens

import PrimaryButton
import UserInputField
import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.carrazosv3.R
import mx.edu.utez.carrazosv3.ui.components.images.CircularImage
import mx.edu.utez.carrazosv3.ui.components.inputs.PasswordField
import mx.edu.utez.carrazosv3.ui.theme.CalculadoraMVVMTheme
import mx.edu.utez.gato.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF000000), Color(0xFF1A1A1A))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .wrapContentHeight()
                .shadow(12.dp, RoundedCornerShape(20.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF121212)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                // Logo principal más grande
                Image(
                    painter = painterResource(id = R.drawable.huevo),
                    contentDescription = "Logo Carrazos",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(top = 10.dp)
                )

                // Título grande
                Text(
                    text = "Carrazos",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFFF2B2B),
                    textAlign = TextAlign.Center
                )

                // Campo de usuario
                UserInputField(
                    viewModel = viewModel,
                    label = "Usuario"
                )

                // Campo de contraseña
                PasswordField(
                    viewModel = viewModel,
                    label = "Contraseña"
                )

                // Mensaje de error animado
                AnimatedVisibility(visible = viewModel.loginError.value.isNotEmpty()) {
                    Text(
                        text = viewModel.loginError.value,
                        color = Color.Red,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }

                // Botón "¿Olvidé mi contraseña?"
                OutlinedButton(
                    onClick = { navController.navigate("forgot_password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFFFF2B2B)
                    ),
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.5.dp)
                ) {
                    Text("¿Olvidé mi contraseña?", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                }

                // Botón principal de inicio de sesión
                Button(
                    onClick = {
                        viewModel.login {
                            navController.navigate("menu") {
                                popUpTo("login") { inclusive = true }
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF2B2B),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Iniciar sesión", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }

                // Texto divisor
                Text(
                    text = "O ingresa con",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )

                // Botones sociales
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SocialButton(R.drawable.polluelo)
                    SocialButton(R.drawable.polluelo)
                    SocialButton(R.drawable.polluelo)
                    SocialButton(R.drawable.polluelo)
                }

                // Botón "Registrarse" más visible
                OutlinedButton(
                    onClick = { navController.navigate("register") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White
                    ),
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.5.dp, brush = Brush.linearGradient(listOf(Color.Red, Color.White)))
                ) {
                    Text(
                        "¿No tienes cuenta? Regístrate",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

// Botón de red social (solo visual)
@Composable
fun SocialButton(iconRes: Int) {
    Box(
        modifier = Modifier
            .size(55.dp)
            .clip(CircleShape)
            .background(Color(0xFF202020))
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
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

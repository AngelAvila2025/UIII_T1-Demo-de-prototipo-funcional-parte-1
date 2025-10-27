package mx.edu.utez.carrazosv3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(navController: NavController) {
    val emailState = remember { mutableStateOf("") }
    val infoState = remember { mutableStateOf("") }
    val loadingState = remember { mutableStateOf(false) }

    // Fondo gris claro
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentAlignment = Alignment.Center
    ) {
        // Tarjeta centrada
        Card(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Título
                Text(
                    text = "Recuperar contraseña",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )

                // Instrucción
                Text(
                    text = "Ingresa tu correo electrónico y te enviaremos un enlace para restablecer tu contraseña.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center
                )

                // Campo de correo
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                        infoState.value = ""
                    },
                    label = { Text("Correo electrónico") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true
                )

                // Botón principal
                Button(
                    onClick = {
                        val email = emailState.value.trim()
                        if (email.isEmpty()) {
                            infoState.value = "Por favor ingresa tu correo."
                            return@Button
                        }
                        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                            infoState.value = "Ingresa un correo válido."
                            return@Button
                        }

                        loadingState.value = true
                        // Simulación de envío
                        infoState.value =
                            "Si existe una cuenta con $email, recibirás un correo con instrucciones."
                        loadingState.value = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = if (loadingState.value) "Enviando..." else "Enviar enlace",
                        fontSize = 16.sp
                    )
                }

                // Mensaje de estado
                if (infoState.value.isNotEmpty()) {
                    Text(
                        text = infoState.value,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }

                // 🔹 Enlace para volver al login (sin cerrar la app)
                TextButton(
                    onClick = {
                        // Esta línea te regresa a tu pantalla "login"
                        navController.navigate("login") {
                            popUpTo("forgot_password") { inclusive = true }
                        }
                    }
                ) {
                    Text(
                        text = "Volver al inicio de sesión",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}

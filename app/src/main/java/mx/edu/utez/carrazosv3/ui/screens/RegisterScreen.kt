package mx.edu.utez.carrazosv3.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.edu.utez.carrazosv3.ui.components.buttons.PrimaryButton

@Composable
fun RegisterScreen(navController: NavController) {
    // Estados de los campos
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmarContrasena by remember { mutableStateOf("") }

    // Colores blanco y negro
    val fondo = Color.Black
    val texto = Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Crear cuenta",
            style = MaterialTheme.typography.headlineMedium,
            color = texto
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Campo Nombre
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre completo", color = texto) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = texto,
                unfocusedTextColor = texto,
                focusedBorderColor = texto,
                unfocusedBorderColor = texto,
                cursorColor = texto
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo Correo
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico", color = texto) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = texto,
                unfocusedTextColor = texto,
                focusedBorderColor = texto,
                unfocusedBorderColor = texto,
                cursorColor = texto
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo Contraseña
        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña", color = texto) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = texto,
                unfocusedTextColor = texto,
                focusedBorderColor = texto,
                unfocusedBorderColor = texto,
                cursorColor = texto
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Confirmar Contraseña
        OutlinedTextField(
            value = confirmarContrasena,
            onValueChange = { confirmarContrasena = it },
            label = { Text("Confirmar contraseña", color = texto) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = texto,
                unfocusedTextColor = texto,
                focusedBorderColor = texto,
                unfocusedBorderColor = texto,
                cursorColor = texto
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón de Registro
        PrimaryButton("Registrar") {
            if (nombre.isNotBlank() && correo.isNotBlank() && contrasena == confirmarContrasena) {
                println("Usuario registrado: $nombre ($correo)")
                navController.navigate("login")
            } else {
                println("Error: Verifica los datos")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Volver al Login
        TextButton(onClick = { navController.popBackStack() }) {
            Text("¿Ya tienes cuenta? Inicia sesión", color = texto)
        }
    }
}

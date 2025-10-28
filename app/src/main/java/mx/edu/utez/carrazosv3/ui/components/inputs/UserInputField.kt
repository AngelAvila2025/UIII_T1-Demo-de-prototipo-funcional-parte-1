package mx.edu.utez.carrazosv3.ui.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import mx.edu.utez.carrazosv3.viewmodel.LoginViewModel


@Composable
fun UserInputField(viewModel: LoginViewModel, label: String) {
    OutlinedTextField(
        value = viewModel.username.value,
        onValueChange = { viewModel.username.value = it },
        label = { Text(label, color = Color.White) },
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        )
    )
}

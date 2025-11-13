package mx.edu.utez.carrazosv3.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import mx.edu.utez.carrazosv3.data.model.Carro
import mx.edu.utez.carrazosv3.viewmodel.MenuViewModel

// Archivo: screens/CarroItem.kt (o dentro de MenuScreen.kt, si es pequeño)

@Composable
fun CarroItem(carro: Carro, viewModel: MenuViewModel) {
    Card(/* ... */) {
        Row(/* ... */) {
            // ... Información del carro (Imagen, nombre, precio)

            // ❌ Botón ELIMINAR
            IconButton(onClick = {
                viewModel.deleteCarro(carro.id) // Llama a la función de eliminar
            }) {
                Icon(Icons.Filled.Delete, contentDescription = "Eliminar")
            }

            // ✏️ Botón ACTUALIZAR (Generalmente abre un diálogo o nueva pantalla)
            IconButton(onClick = {
                // Aquí deberías abrir un diálogo/pantalla de edición,
                // y luego llamar a viewModel.updateCarro(...) al guardar
            }) {
                Icon(Icons.Filled.Edit, contentDescription = "Editar")
            }
        }
    }
}
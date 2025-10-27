package mx.edu.utez.carrazosv3.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import mx.edu.utez.carrazosv3.R
import mx.edu.utez.carrazosv3.data.model.User

class UserListViewModel: ViewModel(){

    // 1. ESTADO: Privado y mutable para el ViewModel, similar a mutableState pero para viewModel
    private val _items = MutableStateFlow<List<User>>(emptyList())

    // 2. DATOS: Público e inmutable para la UI, similar a mutableState pero para viewModel
    val items: StateFlow<List<User>> = _items

    init {
        // Carga los datos iniciales cuando se crea el ViewModel
        //Este metodo se ejecuta cuando se manda a llamar el viewModel por primera vez
        // Es importante para siguientes temas de conección a BD
        loadItems()
    }

    // 3. EVENTO: Función pública para que la UI notifique una acción
    fun onItemClicked(item: User) {
        // --- AQUÍ VA LA LÓGICA DE NEGOCIO ---
        // Por ejemplo:
        // - Navegar a otra pantalla
        // - Marcar el elemento como seleccionado
        // - Realizar una llamada a la API
        // - Actualizar el estado
        // En este caso solo mostramos un mensaje en el LogCat:
        println("ViewModel ha sido notificado del clic en: ${item.nombre}")
    }

    private fun loadItems() {
        // Aquí cargarías los datos desde un repositorio (base de datos, API, etc.)
        // Por ahora, usamos datos de ejemplo.
        _items.value = listOf(
            User(1, R.drawable.maleprofile,"Carlos","carlos@gmail.com","7771231425", 0),
            User(2, R.drawable.femaleprofile,"Berenice","berenice@gmail.com","7771233527", 1),
            User(3, R.drawable.maleprofile,"Yoed","yoed@gmail.com","7773453425", 0),
            User(4, R.drawable.maleprofile,"Luis","luis@gmail.com","7773458975", 0),
            User(5, R.drawable.femaleprofile,"Jetzemani","jetze@gmail.com","777372735", 1),
            User(6, R.drawable.femaleprofile,"Dulce","Dulce@gmail.com","777372735", 1)
        )
    }
}
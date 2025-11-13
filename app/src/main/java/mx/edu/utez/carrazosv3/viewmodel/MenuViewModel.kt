package mx.edu.utez.carrazosv3.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import mx.edu.utez.carrazosv3.R
import mx.edu.utez.carrazosv3.data.model.Carro

class MenuViewModel : ViewModel() {

    // Lista de carros en el carrito (mantener tu función original)
    val cartItems = mutableStateListOf<Carro>()

    // Lista de autos (Hecha mutable y expuesta para las operaciones CRUD)
    // Inicialización con tus datos originales
    private val _carList = mutableStateListOf(
        Carro(1,"Mazda 3 2016 2.5", "Excelente estado, transmisión automática, 70,000 km, único dueño, factura original.", 158900.00, R.drawable.pnn),
        Carro(2,"Toyota Corolla 2019", "Único dueño, motor eficiente, interiores de lujo, excelente estado.", 235000.00, R.drawable.corrolla),
        Carro(3,"Honda Civic 2020", "Versión sport, todo eléctrico, poco uso, A/C, encendido de botón.", 245000.00, R.drawable.civic)
    )

    // La lista pública que la UI observará
    val carList: List<Carro> = _carList


    // --- OPERACIONES CRUD ---

    /**
     * 🟢 Agregar (CREATE) un nuevo carro a la lista principal.
     */
    fun addCarro(newCarro: Carro) {
        // Asigna un nuevo ID, generalmente esto lo haría una base de datos.
        // Aquí, simplemente usa el ID más alto + 1.
        val newId = (_carList.maxOfOrNull { it.id } ?: 0) + 1
        val carroWithId = newCarro.copy(id = newId)
        _carList.add(carroWithId)
    }

    /**
     * 🟡 Actualizar (UPDATE) los datos de un carro existente.
     * Busca el carro por su ID y lo reemplaza con el objeto actualizado.
     */
    fun updateCarro(updatedCarro: Carro) {
        val index = _carList.indexOfFirst { it.id == updatedCarro.id }
        if (index != -1) {
            _carList[index] = updatedCarro
        }
        // Nota: Si el carro actualizado estaba en el carrito, también debería actualizarse ahí,
        // pero por simplicidad solo actualizamos la lista principal.
    }

    /**
     * 🔴 Eliminar (DELETE) un carro de la lista principal por su ID.
     */
    fun deleteCarro(carroId: Int) {
        // Elimina el primer elemento que cumpla con la condición (el ID)
        _carList.removeIf { it.id == carroId }

        // También elimina del carrito si estaba ahí
        cartItems.removeIf { it.id == carroId }
    }


    // --- TU FUNCIÓN ORIGINAL ---

    /**
     * Función para añadir un carro al carrito (función original).
     */
    fun addToCart(carro: Carro) {
        if (!cartItems.contains(carro)) cartItems.add(carro)
    }
}
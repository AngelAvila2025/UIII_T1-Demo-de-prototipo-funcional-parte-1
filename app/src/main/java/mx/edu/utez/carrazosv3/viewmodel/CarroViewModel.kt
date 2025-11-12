package mx.edu.utez.carrazosv3.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mx.edu.utez.carrazosv3.data.model.Carro
import mx.edu.utez.carrazosv3.data.remote.ApiClient
import mx.edu.utez.carrazosv3.data.remote.CarroService
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.awaitResponse
import java.io.File

class CarroViewModel : ViewModel() {
    private val api = ApiClient.retrofit.create(CarroService::class.java)

    // Estado UI Compose
    var listaCarros = mutableStateListOf<Carro>()
    var mensajeError = mutableStateOf<String?>(null)
    var carroEditando = mutableStateOf<Carro?>(null)

    // --- GET: Obtener todos los carros ---
    fun obtenerCarros() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = api.getCarros().awaitResponse()
                if (response.isSuccessful) {
                    val data = response.body() ?: emptyList()
                    listaCarros.clear()
                    listaCarros.addAll(data)
                } else {
                    mensajeError.value = "Error HTTP ${response.code()}"
                }
            } catch (e: Exception) {
                mensajeError.value = e.message ?: "Error desconocido"
            }
        }
    }

    // --- DELETE: Eliminar un carro ---
    fun eliminarCarro(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = api.deleteCarro(id).awaitResponse()
                if (response.isSuccessful) {
                    listaCarros.removeIf { it.id == id }
                } else {
                    mensajeError.value = "Error HTTP ${response.code()}"
                }
            } catch (e: Exception) {
                mensajeError.value = e.message ?: "Error desconocido"
            }
        }
    }

    // --- POST: Crear carro con multipart ---
    fun crearCarro(
        nombre: String,
        descripcion: String,
        precio: Double,
        imagenFile: File?
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val nombrePart = RequestBody.create("text/plain".toMediaTypeOrNull(), nombre)
                val descPart = RequestBody.create("text/plain".toMediaTypeOrNull(), descripcion)
                val precioPart = RequestBody.create("text/plain".toMediaTypeOrNull(), precio.toString())

                val imagenPart = imagenFile?.let {
                    val reqFile = RequestBody.create("image/*".toMediaTypeOrNull(), it)
                    MultipartBody.Part.createFormData("imagen", it.name, reqFile)
                }

                val response = api.createCarro(nombrePart, descPart, precioPart, imagenPart).awaitResponse()
                if (response.isSuccessful) {
                    response.body()?.let {
                        listaCarros.add(it)
                    }
                } else {
                    mensajeError.value = "Error HTTP ${response.code()}"
                }
            } catch (e: Exception) {
                mensajeError.value = e.message ?: "Error desconocido"
            }
        }
    }

    // --- PUT: Actualizar carro ---
    fun actualizarCarro(
        id: Int,
        nombre: String,
        descripcion: String,
        precio: Double,
        imagenFile: File?
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val nombrePart = RequestBody.create("text/plain".toMediaTypeOrNull(), nombre)
                val descPart = RequestBody.create("text/plain".toMediaTypeOrNull(), descripcion)
                val precioPart = RequestBody.create("text/plain".toMediaTypeOrNull(), precio.toString())

                val imagenPart = imagenFile?.let {
                    val reqFile = RequestBody.create("image/*".toMediaTypeOrNull(), it)
                    MultipartBody.Part.createFormData("imagen", it.name, reqFile)
                }

                val response = api.updateCarro(id, nombrePart, descPart, precioPart, imagenPart).awaitResponse()
                if (response.isSuccessful) {
                    response.body()?.let { carroActualizado ->
                        val index = listaCarros.indexOfFirst { it.id == id }
                        if (index != -1) {
                            listaCarros[index] = carroActualizado
                        }
                        carroEditando.value = null
                    }
                } else {
                    mensajeError.value = "Error HTTP ${response.code()}"
                }
            } catch (e: Exception) {
                mensajeError.value = e.message ?: "Error desconocido"
            }
        }
    }

    // --- Modo edición ---
    fun iniciarEdicion(carro: Carro) {
        carroEditando.value = carro
    }

    fun cancelarEdicion() {
        carroEditando.value = null
    }
}

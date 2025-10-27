package mx.edu.utez.carrazosv3.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var numero1 = mutableStateOf("")
    var numero2 = mutableStateOf("")
    var resultado = mutableStateOf("")

    fun suma() {
        if (numero1.value.isNotEmpty() && numero2.value.isNotEmpty()) {
            resultado.value = (numero1.value.toDouble() + numero2.value.toDouble()).toString()
        } else {
            resultado.value = "Ingresa los dos números primero"
        }
    }

}
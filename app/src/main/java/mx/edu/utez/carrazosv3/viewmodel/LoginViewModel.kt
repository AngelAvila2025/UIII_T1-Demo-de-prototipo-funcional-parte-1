package mx.edu.utez.carrazosv3.viewmodel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var username = mutableStateOf("")
    var password = mutableStateOf("")
    var loginError = mutableStateOf("")

    fun login(onSuccess: () -> Unit) {
        if (username.value == "admin" && password.value == "123") {
            loginError.value = ""
            onSuccess()
        } else {
            loginError.value = "Usuario o contraseña incorrectos"
        }
    }
}

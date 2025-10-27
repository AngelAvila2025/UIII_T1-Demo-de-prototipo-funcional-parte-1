package mx.edu.utez.carrazosv3.data.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import mx.edu.utez.carrazosv3.R

data class Ave(
    val id: Int,
    var estado: MutableState<Estado> = mutableStateOf(Estado.HUEVO),
    var clicks: MutableState<Int> = mutableStateOf(0)
) {
    enum class Estado {
        HUEVO,
        POLLUELO,
        ADULTO,
        CRUDO,
        ROSTIZADO
    }

    fun drawableId(): Int {
        return when (estado.value) {
            Estado.HUEVO -> R.drawable.huevo
            Estado.POLLUELO -> R.drawable.polluelo
            Estado.ADULTO -> R.drawable.adulto
            Estado.CRUDO -> R.drawable.crudo
            Estado.ROSTIZADO -> R.drawable.rostizado
        }
    }
}
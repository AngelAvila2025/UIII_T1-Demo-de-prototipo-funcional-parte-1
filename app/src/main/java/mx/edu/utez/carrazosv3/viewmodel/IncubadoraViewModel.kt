package mx.edu.utez.carrazosv3.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import mx.edu.utez.carrazosv3.data.model.Ave

class IncubadoraViewModel : ViewModel() {

    private val queue = ArrayDeque<Ave>().apply {
        add(Ave(1))
        add(Ave(2))
        add(Ave(3))
        add(Ave(4))
        add(Ave(5))
    }

    var aveActual = mutableStateOf<Ave?>(queue.firstOrNull())
        private set

    var puntos = mutableStateOf(0)
        private set

    private val clicksPorEstado = mapOf(
        Ave.Estado.HUEVO to 7,
        Ave.Estado.POLLUELO to 20,
        Ave.Estado.ADULTO to 42,
        Ave.Estado.CRUDO to 112,
        Ave.Estado.ROSTIZADO to 242
    )

    fun onBoxClick() {
        val ave = aveActual.value ?: return

        ave.clicks.value++

        val clicksNecesarios = clicksPorEstado[ave.estado.value] ?: Int.MAX_VALUE

        if (ave.clicks.value >= clicksNecesarios) {
            when (ave.estado.value) {
                Ave.Estado.HUEVO -> {
                    ave.estado.value = Ave.Estado.POLLUELO
                    ave.clicks.value = 0
                }
                Ave.Estado.POLLUELO -> {
                    ave.estado.value = Ave.Estado.ADULTO
                    ave.clicks.value = 0
                }
                Ave.Estado.ADULTO -> {
                    ave.estado.value = Ave.Estado.CRUDO
                    ave.clicks.value = 0
                }
                Ave.Estado.CRUDO -> {
                    ave.estado.value = Ave.Estado.ROSTIZADO
                    ave.clicks.value = 0
                }
                Ave.Estado.ROSTIZADO -> {
                    puntos.value += 400
                    avanzarSiguienteAve()
                }
            }
        } else {
            aveActual.value = ave
        }
    }

    private fun avanzarSiguienteAve() {
        if (queue.isNotEmpty()) {
            queue.removeFirst()
        }

        aveActual.value = queue.firstOrNull()
    }

    fun avesRestantes(): Int = queue.size
}
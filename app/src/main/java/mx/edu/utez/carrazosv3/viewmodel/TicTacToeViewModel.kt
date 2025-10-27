package mx.edu.utez.carrazosv3.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {

    // Tablero 3x3 (X, O, "")
    var board = mutableStateOf(List(3) { MutableList(3) { "" } })
        private set

    // Jugador actual
    var currentPlayer = mutableStateOf("X")
        private set

    var statusMessage = mutableStateOf("Turno de X")
        private set
    var gameOver = mutableStateOf(false)
        private set

    fun onCellClicked(row: Int, col: Int) {
        if (gameOver.value || board.value[row][col].isNotEmpty()) return

        val newBoard = board.value.map { it.toMutableList() }
        newBoard[row][col] = currentPlayer.value
        board.value = newBoard

        if (checkWinner()) {
            statusMessage.value = "¡Jugador ${currentPlayer.value} ha ganado!"
            gameOver.value = true
        } else if (isBoardFull()) {
            statusMessage.value = "Empate"
            gameOver.value = true
        } else {
            currentPlayer.value = if (currentPlayer.value == "X") "O" else "X"
            statusMessage.value = "Turno de ${currentPlayer.value}"
        }
    }

    /** Verifica si el tablero está lleno */
    private fun isBoardFull(): Boolean {
        return board.value.all { row -> row.all { it.isNotEmpty() } }
    }

    /** Comprueba si hay un ganador */
    private fun checkWinner(): Boolean {
        val b = board.value

        // Filas y columnas
        for (i in 0..2) {
            if (b[i][0] == b[i][1] && b[i][1] == b[i][2] && b[i][0].isNotEmpty()) return true
            if (b[0][i] == b[1][i] && b[1][i] == b[2][i] && b[0][i].isNotEmpty()) return true
        }

        // Diagonales
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2] && b[0][0].isNotEmpty()) return true
        if (b[0][2] == b[1][1] && b[1][1] == b[2][0] && b[0][2].isNotEmpty()) return true

        return false
    }

    /** Reinicia el juego */
    fun resetGame() {
        board.value = List(3) { MutableList(3) { "" } }
        currentPlayer.value = "X"
        statusMessage.value = "Turno de X"
        gameOver.value = false
    }
}
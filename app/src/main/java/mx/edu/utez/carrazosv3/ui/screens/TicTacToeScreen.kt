package mx.edu.utez.carrazosv3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.edu.utez.carrazosv3.ui.components.misc.TicTacToeBoard
import mx.edu.utez.carrazosv3.viewmodel.TicTacToeViewModel

@Composable
fun TicTacToeScreen(viewModel: TicTacToeViewModel = viewModel(), navController: NavController) {

    val board by viewModel.board
    val status by viewModel.statusMessage
    val gameOver by viewModel.gameOver

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = status)

        TicTacToeBoard(
            board = board,
            onCellClick = { row, col -> viewModel.onCellClicked(row, col) },
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        Button(
            onClick = { viewModel.resetGame() },
            enabled = gameOver
        ) {
            Text("Reiniciar juego")
        }
    }
}
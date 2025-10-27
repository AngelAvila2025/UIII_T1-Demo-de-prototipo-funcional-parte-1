package mx.edu.utez.carrazosv3.ui.components.misc

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicTacToeBoard(
    board: List<List<String>>,
    onCellClick: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .aspectRatio(1f)
    ) {
        for (row in 0..2) {
            Row(Modifier.weight(1f)) {
                for (col in 0..2) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .border(2.dp, Color.Black)
                            .clickable { onCellClick(row, col) },
                        contentAlignment = Alignment.Center
                    ) {
                        val symbol = board[row][col]
                        Text(
                            text = symbol,
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Bold,
                            color = when (symbol) {
                                "X" -> Color.Red
                                "O" -> Color.Blue
                                else -> Color.Transparent
                            }
                        )
                    }
                }
            }
        }
    }
}
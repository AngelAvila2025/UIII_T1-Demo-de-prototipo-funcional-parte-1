package mx.edu.utez.carrazosv3.ui.components.misc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.carrazosv3.data.model.Ave
import mx.edu.utez.carrazosv3.viewmodel.IncubadoraViewModel

@Composable
fun Incubadora(viewModel: IncubadoraViewModel, modifier: Modifier = Modifier) {
    val ave = viewModel.aveActual.value

    Box(
        modifier = modifier
            .size(160.dp)
            .border(3.dp, Color.Black)
            .background(Color.Transparent)
            .clickable(enabled = ave != null) { viewModel.onBoxClick() },
        contentAlignment = Alignment.Center
    ) {
        if (ave != null) {
            Image(
                painter = painterResource(id = ave.drawableId()),
                contentDescription = ave.estado.value.name,
                modifier = Modifier.fillMaxSize(0.9f)
            )

            // contador de progreso
            Text(
                text = "${ave.clicks.value} / ${when (ave.estado.value) {
                    Ave.Estado.HUEVO -> 7
                    Ave.Estado.POLLUELO -> 20
                    Ave.Estado.ADULTO -> 42
                    Ave.Estado.CRUDO -> 112
                    Ave.Estado.ROSTIZADO -> 242
                }}",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(Color(0xAA000000))
                    .padding(4.dp)
            )
        } else {
            Text(
                text = "¡Terminaste! ¡No hay más aves!",
                color = Color.Gray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
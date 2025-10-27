import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

@Composable
fun Title(
    text: String,
    fontSize: Int = 24,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = color,
        textAlign = textAlign,
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
    )
}
package mx.edu.utez.carrazosv3.ui.components.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment

@Composable
fun DrawableImage(
    drawableId: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    width: Int? = null,
    height: Int? = null,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center
) {
    var imageModifier = modifier
    if (width != null) {
        imageModifier = imageModifier.width(width.dp)
    }
    if (height != null) {
        imageModifier = imageModifier.height(height.dp)
    }

    Image(
        painter = painterResource(id = drawableId),
        contentDescription = contentDescription,
        contentScale = contentScale,
        alignment = alignment,
        modifier = imageModifier
    )
}

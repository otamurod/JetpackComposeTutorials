package uz.otamurod.circularimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
) {
    Image(
        modifier = Modifier
            .size(300.dp)
            .clip(shape = CircleShape)
            .border(
                width = 10.dp,
                color = Color.Cyan,
                shape = CircleShape
            ),
//            .clip(
//                shape = RoundedCornerShape(size = 50.dp)
//            )
//            .border(
//                width = 10.dp,
//                color = Color.Cyan,
//                shape = RoundedCornerShape(size = 50.dp)
//            ),
        painter = painterResource(id = R.drawable.image),
        contentDescription = "Circular Image"
    )
}

@Preview(name = "MainScreen")
@Composable
private fun PreviewMainScreen() {
    MainScreen()
}
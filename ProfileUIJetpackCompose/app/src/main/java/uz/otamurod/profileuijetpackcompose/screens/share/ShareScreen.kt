package uz.otamurod.profileuijetpackcompose.screens.share

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShareScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Text(text = "ShareScreen")
    }
}

@Preview(name = "ShareScreen")
@Composable
private fun PreviewShareScreen() {
    ShareScreen()
}
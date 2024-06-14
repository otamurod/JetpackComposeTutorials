package uz.otamurod.profileuijetpackcompose.screens.gallery

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GalleryScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Text(text = "GalleryScreen")
    }
}

@Preview(name = "GalleryScreen")
@Composable
private fun PreviewGalleryScreen() {
    GalleryScreen()
}
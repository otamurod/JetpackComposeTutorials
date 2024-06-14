package uz.otamurod.profileuijetpackcompose.screens.playlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PlaylistScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Text(text = "PlaylistScreen")
    }
}

@Preview(name = "PlaylistScreen")
@Composable
private fun PreviewPlaylistScreen() {
    PlaylistScreen()
}
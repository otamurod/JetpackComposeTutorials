package uz.otamurod.profileuijetpackcompose.screens.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NotificationsScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Text(text = "NotificationsScreen")
    }
}

@Preview(name = "NotificationsScreen")
@Composable
private fun PreviewNotificationsScreen() {
    NotificationsScreen()
}
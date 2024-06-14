package uz.otamurod.profileuijetpackcompose.screens.editprofile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Text(text = "EditProfileScreen")
    }
}

@Preview(name = "EditProfileScreen")
@Composable
private fun PreviewEditProfileScreen() {
    EditProfileScreen()
}
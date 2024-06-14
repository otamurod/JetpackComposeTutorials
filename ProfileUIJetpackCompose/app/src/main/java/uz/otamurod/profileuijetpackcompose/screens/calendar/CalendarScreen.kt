package uz.otamurod.profileuijetpackcompose.screens.calendar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CalendarScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Text(text = "CalendarScreen")
    }
}

@Preview(name = "CalendarScreen")
@Composable
private fun PreviewCalendarScreen() {
    CalendarScreen()
}
package uz.otamurod.readingsms.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SenderView(sender: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(64.dp)
            .background(MaterialTheme.colors.surface),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = sender, modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onSurface,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(name = "SenderView")
@Composable
private fun PreviewSenderView() {
    SenderView("Otamurod")
}
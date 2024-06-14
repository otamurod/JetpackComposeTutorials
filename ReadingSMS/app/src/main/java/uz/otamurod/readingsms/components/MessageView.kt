package uz.otamurod.readingsms.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.otamurod.readingsms.model.SMSMessage
import uz.otamurod.readingsms.model.parsedDate

@Composable
fun MessageView(
    message: SMSMessage
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.type == 1) Arrangement.Start else Arrangement.End
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(all = 10.dp),
            shape = RoundedCornerShape(size = 12.dp),
            color = if (message.type == 1) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 12.dp)
            ) {
                Text(text = message.message)
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = message.date.parsedDate().split(" ").last(),
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.38f),
                    fontSize = MaterialTheme.typography.body2.fontSize
                )
            }
        }
    }
}
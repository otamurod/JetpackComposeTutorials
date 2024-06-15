package uz.otamurod.supportallscreensizes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.otamurod.supportallscreensizes.ui.theme.SupportAllScreenSizesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SupportAllScreenSizesTheme {
                val windowInfo = rememberWindowInfo()

                if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        // List 1
                        displayFirstList()
                        // List 2
                        displaySecondList()
                    }
                } else {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        LazyColumn(modifier = Modifier.weight(1f)) {
                            // List 1
                            displayFirstList()
                        }
                        LazyColumn(modifier = Modifier.weight(1f)) {
                            // List 2
                            displaySecondList()
                        }
                    }
                }
            }
        }
    }
}

private fun LazyListScope.displaySecondList() {
    items(10) {
        Text(
            text = "Item $it",
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
                .padding(16.dp)
        )
    }
}

private fun LazyListScope.displayFirstList() {
    items(10) {
        Text(
            text = "Item $it",
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SupportAllScreenSizesTheme {
        val windowInfo = rememberWindowInfo()

        if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                // List 1
                displayFirstList()
                // List 2
                displaySecondList()
            }
        } else {
            Row(modifier = Modifier.fillMaxWidth()) {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    // List 1
                    displayFirstList()
                }
                LazyColumn(modifier = Modifier.weight(1f)) {
                    // List 2
                    displaySecondList()
                }
            }
        }
    }
}
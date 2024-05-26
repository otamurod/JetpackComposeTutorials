package uz.otamurod.rowsandcolumns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.rowsandcolumns.ui.theme.RowsAndColumnsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowsAndColumnsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomColumnItem(
                            weight = 3f,
                            color = MaterialTheme.colors.secondary,
                            columnNumber = 1
                        )
                        CustomColumnItem(weight = 1f, columnNumber = 2)
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnScope.CustomColumnItem(
    weight: Float,
    color: Color = MaterialTheme.colors.primary,
    columnNumber: Int
) {
    Surface(
        modifier = Modifier
            .width(500.dp)
            .height(500.dp)
            .weight(weight),
        color = color
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start
        ) {
            CustomRowItem(
                weight = 3f,
                color = MaterialTheme.colors.secondaryVariant,
                columnNumber = columnNumber,
                rowNumber = 1
            )
            CustomRowItem(weight = 1f, columnNumber = columnNumber, rowNumber = 2)
        }
    }
}

@Composable
fun RowScope.CustomRowItem(
    weight: Float,
    color: Color = MaterialTheme.colors.error,
    columnNumber: Int,
    rowNumber: Int
) {
    Surface(
        modifier = Modifier
            .weight(weight),
        color = color
    ) {
        Column {
            Text(textAlign = TextAlign.Center, text = "Column $columnNumber")
            Text(textAlign = TextAlign.Center, text = "Row $rowNumber")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RowsAndColumnsTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomColumnItem(weight = 3f, color = MaterialTheme.colors.secondary, columnNumber = 1)
            CustomColumnItem(weight = 1f, columnNumber = 2)
        }
    }
}
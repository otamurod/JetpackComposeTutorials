package uz.otamurod.superscriptandsubscript

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import uz.otamurod.superscriptandsubscript.ui.theme.SuperscriptAndSubscriptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperscriptAndSubscriptTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    SuperScriptText(
                        normalText = "Android Tutorial",
                        superText = "Superscript",
                        normalTextSize = MaterialTheme.typography.h5.fontSize,
                        superTextSize = MaterialTheme.typography.subtitle2.fontSize,
                        superTextFontWeight = FontWeight.Light
                    )
                    SubScriptText(
                        normalText = "Android Tutorial",
                        subText = "Superscript",
                        normalTextSize = MaterialTheme.typography.h5.fontSize,
                        subTextSize = MaterialTheme.typography.subtitle2.fontSize,
                        subTextFontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}

@Composable
fun SuperScriptText(
    normalText: String,
    normalTextSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    superText: String,
    superTextSize: TextUnit = MaterialTheme.typography.overline.fontSize,
    superTextFontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalTextSize, color = Color.Green
                )
            ) {
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = superTextSize,
                    fontWeight = superTextFontWeight,
                    baselineShift = BaselineShift.Superscript,
                    color = Color.Blue
                )
            ) {
                append(" $superText")
            }
        }, modifier = Modifier
            .background(Color.White)
            .padding(12.dp)
    )
}

@Composable
fun SubScriptText(
    normalText: String,
    normalTextSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    subText: String,
    subTextSize: TextUnit = MaterialTheme.typography.overline.fontSize,
    subTextFontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalTextSize, color = Color.White
                )
            ) {
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = subTextSize,
                    fontWeight = subTextFontWeight,
                    baselineShift = BaselineShift.Subscript,
                    color = Color.Black
                )
            ) {
                append(" $subText")
            }
        }, modifier = Modifier
            .background(Color.Cyan)
            .padding(12.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperscriptAndSubscriptTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .background(Color.Yellow)
                    .padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SuperScriptText(
                    normalText = "Android Tutorial",
                    superText = "Superscript",
                    normalTextSize = MaterialTheme.typography.h5.fontSize,
                    superTextSize = MaterialTheme.typography.subtitle2.fontSize,
                    superTextFontWeight = FontWeight.Light
                )
                SubScriptText(
                    normalText = "Android Tutorial",
                    subText = "Superscript",
                    normalTextSize = MaterialTheme.typography.h5.fontSize,
                    subTextSize = MaterialTheme.typography.subtitle2.fontSize,
                    subTextFontWeight = FontWeight.Light
                )
            }
        }
    }
}
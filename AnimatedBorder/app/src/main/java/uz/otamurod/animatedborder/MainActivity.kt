package uz.otamurod.animatedborder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.animatedborder.ui.theme.AnimatedBorderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedBorderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colors.background)
                            .padding(all = 24.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AnimatedBorderCard(modifier = Modifier
                            .fillMaxWidth(),
                            shape = RoundedCornerShape(size = 16.dp),
                            borderWidth = 4.dp,
                            gradient = Brush.linearGradient(listOf(Color.Magenta, Color.Cyan)),
                            onCardClick = {},
                            content = { CardContent() })
                    }
                }
            }
        }
    }
}

@Composable
fun CardContent() {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.surface)
            .padding(all = 24.dp)
    ) {
        Text(
            text = "Welcome",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h5.fontSize,
            color = MaterialTheme.colors.onSurface
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut eleifend dictum elementum. Proin nisl elit, viverra eget pulvinar accumsan, sagittis et lectus. Aliquam erat volutpat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vestibulum commodo rutrum lacus vel condimentum. Etiam bibendum massa id gravida tempor. Donec vestibulum lorem eu auctor luctus. Mauris at velit et augue pretium fringilla sit amet eget quam. Pellentesque elementum, enim non aliquet fermentum, nunc nibh euismod velit, id volutpat dui ipsum nec magna. Pellentesque ipsum odio, gravida in risus sed, sagittis euismod sem. Nulla facilisi. Aliquam consectetur augue vel porttitor efficitur. Suspendisse pharetra nulla non arcu sagittis tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            fontSize = MaterialTheme.typography.body1.fontSize,
            maxLines = 10,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimatedBorderTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
                .padding(all = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedBorderCard(modifier = Modifier
                .fillMaxWidth(),
                shape = RoundedCornerShape(size = 16.dp),
                borderWidth = 4.dp,
                gradient = Brush.linearGradient(listOf(Color.Magenta, Color.Cyan)),
                onCardClick = {},
                content = { CardContent() })
        }
    }
}
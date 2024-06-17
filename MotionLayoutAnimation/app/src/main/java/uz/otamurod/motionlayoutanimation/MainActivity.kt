package uz.otamurod.motionlayoutanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.motionlayoutanimation.componenets.ProfileHeader
import uz.otamurod.motionlayoutanimation.ui.theme.MotionLayoutAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotionLayoutAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        var progress by remember {
                            mutableStateOf(0f)
                        }
                        ProfileHeader(progress = progress)
                        Spacer(modifier = Modifier.height(32.dp))
                        Slider(
                            value = progress, onValueChange = {
                                progress = it
                            },
                            modifier = Modifier.padding(horizontal = 32.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MotionLayoutAnimationTheme {

    }
}
package uz.otamurod.multiplescreensizesupport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import uz.otamurod.multiplescreensizesupport.navigation.SetupNavGraph
import uz.otamurod.multiplescreensizesupport.screen.home.HomeScreen
import uz.otamurod.multiplescreensizesupport.ui.theme.MultipleScreenSizeSupportTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultipleScreenSizeSupportTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val windowSize = rememberWindowSize()
                    val navController = rememberNavController()
                    SetupNavGraph(windowSize = windowSize, navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MultipleScreenSizeSupportTheme {
        val windowSize = rememberWindowSize()
        HomeScreen(windowSize = windowSize)
    }
}
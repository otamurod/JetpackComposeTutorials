package uz.otamurod.nested_nav_bottom_bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import uz.otamurod.nested_nav_bottom_bar.graphs.RootNavGraph
import uz.otamurod.nested_nav_bottom_bar.ui.theme.NestedNavigationWithBottomBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedNavigationWithBottomBarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RootNavGraph(navController = rememberNavController())
                }
            }
        }
    }
}
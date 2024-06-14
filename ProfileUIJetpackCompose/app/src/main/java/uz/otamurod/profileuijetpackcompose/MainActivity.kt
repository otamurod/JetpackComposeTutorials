package uz.otamurod.profileuijetpackcompose

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
import uz.otamurod.profileuijetpackcompose.navigation.SetUpNavGraph
import uz.otamurod.profileuijetpackcompose.ui.theme.ProfileUIJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileUIJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    SetUpNavGraph(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ProfileUIJetpackComposeTheme {
        SetUpNavGraph(navController = rememberNavController())
    }
}
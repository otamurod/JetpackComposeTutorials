package uz.otamurod.paging3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import dagger.hilt.android.AndroidEntryPoint
import uz.otamurod.paging3.navigation.SetUpNavGraph
import uz.otamurod.paging3.ui.theme.Paging3Theme

@OptIn(ExperimentalCoilApi::class)
@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Paging3Theme {
                val navHostController = rememberNavController()
                SetUpNavGraph(navHostController = navHostController)
            }
        }
    }
}

@OptIn(ExperimentalPagingApi::class, ExperimentalCoilApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Paging3Theme {
        SetUpNavGraph(navHostController = rememberNavController())
    }
}
package uz.otamurod.paging3.screens.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import uz.otamurod.paging3.navigation.Screen
import uz.otamurod.paging3.screens.common.ListContent

@OptIn(ExperimentalCoilApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController, homeViewModel: HomeViewModel = hiltViewModel()
) {
    val getAllImages = homeViewModel.allImages.collectAsLazyPagingItems()

    Scaffold(topBar = {
        HomeTopBar(
            onSearchClicked = {
                navController.navigate(Screen.Search.route)
            }
        )
    }, content = {
        ListContent(items = getAllImages)
    })
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(rememberNavController())
}
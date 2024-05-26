package uz.otamurod.paging3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import uz.otamurod.paging3.screens.home.HomeScreen
import uz.otamurod.paging3.screens.search.SearchScreen

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navHostController)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navController = navHostController)
        }
    }
}
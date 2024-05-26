package uz.otamurod.multiplescreensizesupport.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.otamurod.multiplescreensizesupport.WindowSize
import uz.otamurod.multiplescreensizesupport.screen.home.HomeScreen

@Composable
fun SetupNavGraph(windowSize: WindowSize, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(windowSize = windowSize)
        }
    }
}
package uz.otamurod.bottomnavigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.otamurod.bottomnavigation.bottom_bar.BottomBarScreen
import uz.otamurod.bottomnavigation.screens.HomeScreen
import uz.otamurod.bottomnavigation.screens.ProfileScreen
import uz.otamurod.bottomnavigation.screens.SettingsScreen

@Composable
fun BottomNavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Settings.route){
            SettingsScreen()
        }
    }
}

@Preview(name = "BottomNavGraph")
@Composable
private fun PreviewBottomNavGraph() {
    BottomNavGraph(navHostController = rememberNavController())
}
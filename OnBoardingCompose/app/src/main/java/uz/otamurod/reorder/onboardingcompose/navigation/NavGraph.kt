package uz.otamurod.reorder.onboardingcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.otamurod.reorder.onboardingcompose.navigation.Screen.Home
import uz.otamurod.reorder.onboardingcompose.navigation.Screen.Welcome
import uz.otamurod.reorder.onboardingcompose.screen.home.HomeScreen
import uz.otamurod.reorder.onboardingcompose.screen.welcome.WelcomeScreen

@Composable
fun SetUpNavGraph(navHostController: NavHostController, startDestination:String) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(route = Welcome.route) {
            WelcomeScreen(navController = navHostController)
        }
        composable(route = Home.route) {
            HomeScreen()
        }
    }
}
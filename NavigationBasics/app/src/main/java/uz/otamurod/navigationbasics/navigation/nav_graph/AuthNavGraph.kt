package uz.otamurod.navigationbasics.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import uz.otamurod.navigationbasics.navigation.AUTH_GRAPH_ROUTE
import uz.otamurod.navigationbasics.navigation.Screen
import uz.otamurod.navigationbasics.screens.LoginScreen
import uz.otamurod.navigationbasics.screens.SignUpScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Login.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.Login.route
        ) {
            LoginScreen(navController = navController)
        }

        composable(
            route = Screen.SignUp.route
        ) {
            SignUpScreen(navController = navController)
        }
    }
}
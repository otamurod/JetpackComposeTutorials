package uz.otamurod.navigationbasics.navigation.nav_graph

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import uz.otamurod.navigationbasics.navigation.DETAIL_SCREEN_ARGUMENT_1_KEY
import uz.otamurod.navigationbasics.navigation.DETAIL_SCREEN_ARGUMENT_2_KEY
import uz.otamurod.navigationbasics.navigation.HOME_GRAPH_ROUTE
import uz.otamurod.navigationbasics.navigation.Screen
import uz.otamurod.navigationbasics.screens.DetailScreen
import uz.otamurod.navigationbasics.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.DetailScreen.route,
            arguments = listOf(
                navArgument(DETAIL_SCREEN_ARGUMENT_1_KEY) {
                    type = NavType.IntType
                },
                navArgument(DETAIL_SCREEN_ARGUMENT_2_KEY) {
                    type = NavType.StringType
                })
        ) {
            Log.d("Args", "SetUpNavGraph: ${it.arguments?.getInt(DETAIL_SCREEN_ARGUMENT_1_KEY)}")
            Log.d("Args", "SetUpNavGraph: ${it.arguments?.getString(DETAIL_SCREEN_ARGUMENT_2_KEY)}")
            DetailScreen(navController)
        }
    }
}
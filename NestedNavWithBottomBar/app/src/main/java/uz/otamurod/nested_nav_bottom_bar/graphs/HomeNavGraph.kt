package uz.otamurod.nested_nav_bottom_bar.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import uz.otamurod.nested_nav_bottom_bar.bottom_bar.BottomBarScreen
import uz.otamurod.nested_nav_bottom_bar.graphs.DetailsScreenRoute.INFORMATION
import uz.otamurod.nested_nav_bottom_bar.graphs.DetailsScreenRoute.OVERVIEW
import uz.otamurod.nested_nav_bottom_bar.screens.ScreenContent

@Composable
fun HomeNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(
            route = BottomBarScreen.Home.route
        ) {
            ScreenContent(
                name = BottomBarScreen.Home.title,
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )
        }
        composable(
            route = BottomBarScreen.Profile.route
        ) {
            ScreenContent(
                name = BottomBarScreen.Profile.title,
                onClick = {

                }
            )
        }
        composable(
            route = BottomBarScreen.Settings.route
        ) {
            ScreenContent(
                name = BottomBarScreen.Settings.title,
                onClick = {

                }
            )
        }

        detailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(
            route = DetailsScreen.Information.route
        ) {
            ScreenContent(
                name = DetailsScreen.Information.route
            ) {
                navController.navigate(DetailsScreen.Overview.route)
            }
        }

        composable(
            route = DetailsScreen.Overview.route
        ) {
            ScreenContent(
                name = DetailsScreen.Overview.route
            ) {
                navController.popBackStack()
            }
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(INFORMATION)
    object Overview : DetailsScreen(OVERVIEW)
}

object DetailsScreenRoute {
    const val INFORMATION = "INFORMATION"
    const val OVERVIEW = "OVERVIEW"
}

@Preview(name = "HomeNavGraph", showBackground = true)
@Composable
private fun PreviewHomeNavGraph() {
    HomeNavGraph(navController = rememberNavController())
}
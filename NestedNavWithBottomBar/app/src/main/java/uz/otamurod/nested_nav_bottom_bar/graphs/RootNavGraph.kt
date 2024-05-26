package uz.otamurod.nested_nav_bottom_bar.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.otamurod.nested_nav_bottom_bar.graphs.Graph.AUTH
import uz.otamurod.nested_nav_bottom_bar.graphs.Graph.HOME
import uz.otamurod.nested_nav_bottom_bar.graphs.Graph.ROOT
import uz.otamurod.nested_nav_bottom_bar.screens.home.HomeScreen

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = ROOT,
        startDestination = AUTH
    ) {
        authNavGraph(navController = navController)
        composable(route = HOME) {
            HomeScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val HOME = "home_graph"
    const val AUTH = "auth_graph"
    const val DETAILS = "details_graph"
}

@Preview(name = "RootNavGraph", showBackground = true)
@Composable
private fun PreviewRootNavGraph() {
    RootNavGraph(navController = rememberNavController())
}
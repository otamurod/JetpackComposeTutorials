package uz.otamurod.navigationbasics.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import uz.otamurod.navigationbasics.navigation.HOME_GRAPH_ROUTE
import uz.otamurod.navigationbasics.navigation.ROOT_GRAPH_ROUTE

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}

@Preview(name = "HomeScreen", showBackground = true)
@Composable
fun PreviewSetUpNavGraph() {
    SetUpNavGraph(navController = rememberNavController())
}
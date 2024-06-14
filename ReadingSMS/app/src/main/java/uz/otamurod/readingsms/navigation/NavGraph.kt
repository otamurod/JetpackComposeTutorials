package uz.otamurod.readingsms.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.otamurod.readingsms.screens.MainScreen
import uz.otamurod.readingsms.screens.PermissionScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Permission.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Screen.Permission.route) {
            PermissionScreen(
                onPermissionGranted = {
                    navController.popBackStack()
                    navController.navigate(Screen.Main.route)
                }
            )
        }
        composable(route = Screen.Main.route) {
            MainScreen()
        }
    }
}

@Preview(name = "SetUpNavGraph")
@Composable
private fun PreviewSetUpNavGraph() {
    SetUpNavGraph(navController = rememberNavController())
}
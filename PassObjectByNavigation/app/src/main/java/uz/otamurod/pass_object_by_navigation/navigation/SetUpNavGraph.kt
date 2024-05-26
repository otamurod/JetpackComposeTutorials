package uz.otamurod.pass_object_by_navigation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.otamurod.pass_object_by_navigation.data.Person
import uz.otamurod.pass_object_by_navigation.screen.DetailsScreen
import uz.otamurod.pass_object_by_navigation.screen.HomeScreen
import uz.otamurod.pass_object_by_navigation.screen.SharedViewModel

@Composable
fun SetUpNavGraph(
    navHostController: NavHostController
) {
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navHostController = navHostController, sharedViewModel = sharedViewModel)
        }
        composable(route = Screen.Details.route) {
            /**
             * Method 1: Using BackStackEntry
             * This approach works if we do not remove [HomeScreen] from the [BackStack]
             */
            val personFromBackStackEntry =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<Person>(key = "person")
            Log.d("DetailsScreen", "SetUpNavGraph: ${personFromBackStackEntry?.firstName} ${personFromBackStackEntry?.lastName}")
            DetailsScreen(
                navHostController = navHostController,
                personFromBackStackEntry, // Method 1
                sharedViewModel = sharedViewModel // Method 2
            )
        }
    }
}

@Preview(name = "SetUpNavGraph", showBackground = true)
@Composable
private fun PreviewNavGraph() {
    SetUpNavGraph(navHostController = rememberNavController())
}
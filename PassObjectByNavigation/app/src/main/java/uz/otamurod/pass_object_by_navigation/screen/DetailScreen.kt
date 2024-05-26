package uz.otamurod.pass_object_by_navigation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.otamurod.pass_object_by_navigation.data.Person

@Composable
fun DetailsScreen(
    navHostController: NavHostController,
    personFromBackStackEntry: Person?,
    sharedViewModel: SharedViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navHostController.popBackStack()
            },
        contentAlignment = Alignment.Center
    ) {
        val personFromViewModel = sharedViewModel.person
        // For Method 1
        personFromBackStackEntry?.let {
            Text(text = String.format("%s %s", personFromBackStackEntry.firstName, personFromBackStackEntry.lastName))
        }
        // For Method 2
        personFromViewModel?.let {
            Text(
                text = String.format(
                    "%s %s",
                    personFromViewModel.firstName,
                    personFromViewModel.lastName
                ),
            )
        }
    }
}

@Preview(name = "DetailsScreen")
@Composable
private fun PreviewDetailsScreen() {
    DetailsScreen(
        navHostController = rememberNavController(),
        Person(firstName = "Otamurod", lastName = "Safarov"),
        sharedViewModel = SharedViewModel()
    )
}
package uz.otamurod.pass_object_by_navigation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.otamurod.pass_object_by_navigation.data.Person
import uz.otamurod.pass_object_by_navigation.navigation.Screen

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                /**
                 * Method 1: Using BackStackEntry
                 * This approach works if we do not remove [HomeScreen] from the [BackStack]
                 */
                val person = Person(firstName = "Otamurod", lastName = "Safarov")
                navHostController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "person",
                    value = person
                )
//                navHostController.popBackStack()

                /**
                 * Method 2: Using SharedViewModel
                 * This approach works even if we remove [HomeScreen] from the [BackStack]
                 */
                sharedViewModel.addPerson(person)
                navHostController.popBackStack()
                navHostController.navigate(Screen.Details.route)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "HomeScreen",
            style = TextStyle(
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(navHostController = rememberNavController(), sharedViewModel = SharedViewModel())
}
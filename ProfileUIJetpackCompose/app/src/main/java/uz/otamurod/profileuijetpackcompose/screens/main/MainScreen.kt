package uz.otamurod.profileuijetpackcompose.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.otamurod.profileuijetpackcompose.navigation.Screen

@Composable
fun MainScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Text(text = "MainScreen", modifier = modifier.clickable {
            navController.popBackStack()
            navController.navigate(Screen.Profile.route)
        })
    }
}

@Preview(name = "MainScreen")
@Composable
private fun PreviewMainScreen() {
    MainScreen(rememberNavController())
}
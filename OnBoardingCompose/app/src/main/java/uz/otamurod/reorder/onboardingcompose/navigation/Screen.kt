package uz.otamurod.reorder.onboardingcompose.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome_screen")
    object Home : Screen("home_screen")
}

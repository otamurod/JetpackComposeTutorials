package uz.otamurod.adaptivelayout.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
}
package uz.otamurod.multiplescreensizesupport.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
}
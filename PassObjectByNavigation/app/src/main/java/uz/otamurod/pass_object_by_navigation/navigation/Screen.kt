package uz.otamurod.pass_object_by_navigation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("detail")
}

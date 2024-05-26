package uz.otamurod.nested_nav_bottom_bar.bottom_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import uz.otamurod.nested_nav_bottom_bar.bottom_bar.BottomBarRoute.HOME
import uz.otamurod.nested_nav_bottom_bar.bottom_bar.BottomBarRoute.PROFILE
import uz.otamurod.nested_nav_bottom_bar.bottom_bar.BottomBarRoute.SETTINGS

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = HOME,
        title = "Home",
        Icons.Default.Home
    )

    object Profile : BottomBarScreen(
        route = PROFILE,
        title = "Profile",
        Icons.Default.Person
    )

    object Settings : BottomBarScreen(
        route = SETTINGS,
        title = "Settings",
        Icons.Default.Settings
    )
}

object BottomBarRoute {
    const val HOME = "home_screen"
    const val PROFILE = "profile_screen"
    const val SETTINGS = "settings_screen"
}
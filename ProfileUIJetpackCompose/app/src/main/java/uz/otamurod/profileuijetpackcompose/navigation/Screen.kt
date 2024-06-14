package uz.otamurod.profileuijetpackcompose.navigation

sealed class Screen(val route: String) {
    object Main : Screen(route = "main-screen")
    object Profile : Screen(route = "profile-screen")
    object EditProfile : Screen(route = "edit-profile-screen")
    object Notifications : Screen(route = "notifications-screen")
    object Calendar : Screen(route = "calendar-screen")
    object Gallery : Screen(route = "gallery-screen")
    object Playlist : Screen(route = "playlist-screen")
    object Share : Screen(route = "share-screen")
}

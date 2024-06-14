package uz.otamurod.profileuijetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.otamurod.profileuijetpackcompose.screens.calendar.CalendarScreen
import uz.otamurod.profileuijetpackcompose.screens.editprofile.EditProfileScreen
import uz.otamurod.profileuijetpackcompose.screens.gallery.GalleryScreen
import uz.otamurod.profileuijetpackcompose.screens.main.MainScreen
import uz.otamurod.profileuijetpackcompose.screens.notifications.NotificationsScreen
import uz.otamurod.profileuijetpackcompose.screens.playlist.PlaylistScreen
import uz.otamurod.profileuijetpackcompose.screens.profile.ProfileScreen
import uz.otamurod.profileuijetpackcompose.screens.share.ShareScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Profile.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.EditProfile.route) {
            EditProfileScreen()
        }
        composable(route = Screen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.Notifications.route) {
            NotificationsScreen()
        }
        composable(route = Screen.Calendar.route) {
            CalendarScreen()
        }
        composable(route = Screen.Gallery.route) {
            GalleryScreen()
        }
        composable(route = Screen.Playlist.route) {
            PlaylistScreen()
        }
        composable(route = Screen.Share.route) {
            ShareScreen()
        }
    }
}

@Preview(name = "SetUpNavGraph")
@Composable
private fun PreviewSetUpNavGraph() {
    SetUpNavGraph(navController = rememberNavController())
}
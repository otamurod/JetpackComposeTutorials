package uz.otamurod.paging3.navigation

import uz.otamurod.paging3.util.Constants.HOME_SCREEN_ROUTE
import uz.otamurod.paging3.util.Constants.SEARCH_SCREEN_ROUTE

sealed class Screen(val route: String) {
    object Home : Screen(HOME_SCREEN_ROUTE)
    object Search : Screen(SEARCH_SCREEN_ROUTE)
}

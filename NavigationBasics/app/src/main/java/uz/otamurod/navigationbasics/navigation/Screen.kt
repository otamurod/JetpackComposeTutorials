package uz.otamurod.navigationbasics.navigation

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object DetailScreen : Screen(
        // route with required argument(s)
        route = "detail_screen/{$DETAIL_SCREEN_ARGUMENT_1_KEY}/{$DETAIL_SCREEN_ARGUMENT_2_KEY}"
    ) {
        fun passId(id: Int): String { // single required argument
            return this.route.replace(
                oldValue = "{$DETAIL_SCREEN_ARGUMENT_1_KEY}",
                newValue = id.toString()
            )
        }

        fun passNameAndId(id: Int, name: String): String { // multiple required arguments
            return "detail_screen/$id/$name"
        }
    }

    object Login : Screen(route = "login_screen")
    object SignUp : Screen(route = "sign_up_screen")
}

const val DETAIL_SCREEN_ARGUMENT_1_KEY = "id"
const val DETAIL_SCREEN_ARGUMENT_2_KEY = "name"

const val ROOT_GRAPH_ROUTE = "root"
const val AUTH_GRAPH_ROUTE = "auth"
const val HOME_GRAPH_ROUTE = "home"
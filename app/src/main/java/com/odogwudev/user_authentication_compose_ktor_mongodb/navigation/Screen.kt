package com.odogwudev.user_authentication_compose_ktor_mongodb.navigation

sealed class Screen(val route: String) {
    object Login : Screen(route = "login_screen")
    object Profile : Screen(route = "profile_screen")
}

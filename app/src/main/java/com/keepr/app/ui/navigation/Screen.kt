package com.keepr.app.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddAppliance : Screen("add_appliance")
    object EditAppliance : Screen("edit_appliance/{id}") {
        fun createRoute(id: Long) = "edit_appliance/$id"
    }
    object Detail : Screen("detail/{id}") {
        fun createRoute(id: Long) = "detail/$id"
    }
}

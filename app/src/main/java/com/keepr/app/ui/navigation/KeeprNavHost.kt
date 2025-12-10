package com.keepr.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.keepr.app.ui.screens.add.AddEditApplianceScreen
import com.keepr.app.ui.screens.detail.ApplianceDetailScreen
import com.keepr.app.ui.screens.home.HomeScreen

@Composable
fun KeeprNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToAdd = {
                    navController.navigate(Screen.AddAppliance.route)
                },
                onNavigateToDetail = { id ->
                    navController.navigate(Screen.Detail.createRoute(id))
                },
                onNavigateToEdit = { id ->
                    navController.navigate(Screen.EditAppliance.createRoute(id))
                }
            )
        }
        
        composable(Screen.AddAppliance.route) {
            AddEditApplianceScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(
            route = Screen.EditAppliance.route,
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id") ?: return@composable
            AddEditApplianceScreen(
                applianceId = id,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id") ?: return@composable
            ApplianceDetailScreen(
                applianceId = id,
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToEdit = { editId ->
                    navController.navigate(Screen.EditAppliance.createRoute(editId))
                }
            )
        }
    }
}

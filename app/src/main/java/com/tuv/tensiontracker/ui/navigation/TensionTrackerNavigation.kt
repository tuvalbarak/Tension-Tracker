package com.tuv.tensiontracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.tuv.tensiontracker.ui.screen.home.HomeScreen
import com.tuv.tensiontracker.ui.screen.session.NewSessionScreen
import com.tuv.tensiontracker.ui.screen.history.SessionHistoryScreen
import com.tuv.tensiontracker.ui.screen.session.SessionDetailsScreen
import com.tuv.tensiontracker.ui.screen.session.EditSessionScreen
import com.tuv.tensiontracker.ui.screen.recommendations.RecommendationsScreen
import com.tuv.tensiontracker.ui.screen.settings.SettingsScreen
import com.tuv.tensiontracker.ui.screen.catalog.StringCatalogScreen

@Composable
fun TensionTrackerNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToNewSession = { navController.navigate(Screen.NewSession.route) },
                onNavigateToHistory = { navController.navigate(Screen.SessionHistory.route) },
                onNavigateToRecommendations = { navController.navigate(Screen.Recommendations.route) },
                onNavigateToSettings = { navController.navigate(Screen.Settings.route) },
                onNavigateToSessionDetails = { sessionId ->
                    navController.navigate(Screen.SessionDetails.createRoute(sessionId))
                }
            )
        }
        
        composable(Screen.NewSession.route) {
            NewSessionScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToStringCatalog = { navController.navigate(Screen.StringCatalog.route) }
            )
        }
        
        composable(Screen.SessionHistory.route) {
            SessionHistoryScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToSessionDetails = { sessionId ->
                    navController.navigate(Screen.SessionDetails.createRoute(sessionId))
                }
            )
        }
        
        composable(
            Screen.SessionDetails.route,
            arguments = listOf(navArgument("sessionId") { type = NavType.LongType })
        ) { backStackEntry ->
            val sessionId = backStackEntry.arguments?.getLong("sessionId") ?: 0L
            SessionDetailsScreen(
                sessionId = sessionId,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToEdit = { navController.navigate(Screen.EditSession.createRoute(sessionId)) }
            )
        }
        
        composable(
            Screen.EditSession.route,
            arguments = listOf(navArgument("sessionId") { type = NavType.LongType })
        ) { backStackEntry ->
            val sessionId = backStackEntry.arguments?.getLong("sessionId") ?: 0L
            EditSessionScreen(
                sessionId = sessionId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.Recommendations.route) {
            RecommendationsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.Settings.route) {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.StringCatalog.route) {
            StringCatalogScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
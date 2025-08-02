package com.tuv.tensiontracker.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object NewSession : Screen("new_session")
    object SessionHistory : Screen("session_history")
    object SessionDetails : Screen("session_details/{sessionId}") {
        fun createRoute(sessionId: Long) = "session_details/$sessionId"
    }
    object EditSession : Screen("edit_session/{sessionId}") {
        fun createRoute(sessionId: Long) = "edit_session/$sessionId"
    }
    object Recommendations : Screen("recommendations")
    object Settings : Screen("settings")
    object StringCatalog : Screen("string_catalog")
}
package com.app.hellokmmnetwork.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.hellokmmnetwork.android.detail.NewsDetailScreen
import com.app.hellokmmnetwork.android.home.HomeScreen

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
}

@Composable
fun Navigation(viewModel: AppViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(navHostController = navController, appViewModel = viewModel)
        }
        composable(Screen.DetailScreen.route) {
            NewsDetailScreen(viewModel = viewModel)
        }
    }

}
package com.app.hellokmmnetwork.android.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navHostController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Text(text = "HomeScreen")
    }
}
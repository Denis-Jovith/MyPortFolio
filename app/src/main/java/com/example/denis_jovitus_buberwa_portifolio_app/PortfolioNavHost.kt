package com.example.denis_jovitus_buberwa_portifolio_app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.denis_jovitus_buberwa_portifolio_app.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioNavHost() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),

        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Portfolio App") },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                )
            },
            content = { padding ->
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier.padding(padding)
                ) {
                    composable("home") {
                        HomeScreen(navController = navController) // Home Screen
                    }
                    composable("projectDetail/{projectId}") { backStackEntry ->
                        val projectId = backStackEntry.arguments?.getString("projectId") ?: "Unknown"
                        ProjectDetailScreen(projectId = projectId)
                    }
                    composable("contactForm") {
                        ContactFormScreen()  // Contact Form
                    }
                }
            }
        )
    }
}

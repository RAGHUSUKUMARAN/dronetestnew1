package com.example.dronetestnew.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dronetestnew.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") { WelcomeScreen(navController) }
        composable("home") { HomePage(navController) }
        composable("pdf") { PdfPage(navController) }
        composable("ppt") { PptPage(navController) }
        composable("images") { ImagesPage(navController) }
        composable("videos") { VideosPage(navController) }
        composable("pdf_viewer/{pdfFileName}") { backStackEntry ->
            val pdfFileName = backStackEntry.arguments?.getString("pdfFileName")
            PdfViewerPage(pdfFileName ?: "sample.pdf")
        }

    }
}

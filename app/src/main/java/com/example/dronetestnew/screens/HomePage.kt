package com.example.dronetestnew.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.dronetestnew.models.SectionItem
import com.example.dronetestnew.components.StyledSection
import androidx.navigation.NavHostController
import com.example.dronetestnew.R


@Composable
fun HomePage(navController: NavHostController) {
    // Define sections to display
    val sections = listOf(
        SectionItem(
            title = "PDF Files",
            description = "Explore PDF resources.",
            iconRes = R.drawable.ic_pdf, // Replace with actual drawable resource
            route = "pdf"
        ),
        SectionItem(
            title = "PPT Files",
            description = "View drone presentations.",
            iconRes = R.drawable.ic_ppt, // Replace with actual drawable resource
            route = "ppt"
        ),
        SectionItem(
            title = "Images",
            description = "Explore drone imagery.",
            iconRes = R.drawable.ic_images, // Replace with actual drawable resource
            route = "images"
        ),
        SectionItem(
            title = "Videos",
            description = "Watch drone tutorials.",
            iconRes = R.drawable.ic_videos, // Replace with actual drawable resource
            route = "videos"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD)) // Light blue background
            .padding(horizontal = 15.dp, vertical = 100.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(sections) { section ->
            StyledSection(
                title = section.title,
                description = section.description,
                iconRes = section.iconRes,
                navController = navController,
                route = section.route
            )
        }
    }
}

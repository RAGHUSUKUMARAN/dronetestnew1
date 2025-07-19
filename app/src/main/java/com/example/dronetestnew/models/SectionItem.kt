package com.example.dronetestnew.models

import androidx.annotation.DrawableRes

data class SectionItem(
    val title: String,             // Title of the section
    val description: String,       // Brief description of the section
    @DrawableRes val iconRes: Int, // Resource ID for the section's icon
    val route: String              // Navigation route for the section
)

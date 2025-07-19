package com.example.dronetestnew.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dronetestnew.models.MediaItem

@Composable
fun PptPage(navController: NavHostController) {
    val context = LocalContext.current
    val pptList = listOf(
        MediaItem("Drone Basics", "android.resource://${context.packageName}/raw/drone_basics"),
        MediaItem("Advanced Drone Maneuvers", "android.resource://${context.packageName}/raw/advanced_drone_maneuvers"),
        MediaItem("Drone Safety Guidelines", "android.resource://${context.packageName}/raw/drone_safety_guidelines")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD)) // Light blue background
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Text(
            text = "PPT Resources",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6200EE), // Purple color
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(pptList) { ppt ->
                PptCard(
                    title = ppt.title,
                    onClick = {
                        navController.navigate("ppt_viewer/${Uri.encode(ppt.uri)}")
                    }
                )
            }
        }
    }
}

@Composable
fun PptCard(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF6200EE)) // Purple color
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White, // White text for contrast
                textAlign = TextAlign.Start
            )
        }
    }
}

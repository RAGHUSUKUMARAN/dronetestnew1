package com.example.dronetestnew.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dronetestnew.R

@Composable
fun VideosPage(navController: NavHostController) {
    // Sample list of video items
    val videoList = listOf(
        VideoItem("Drone Basics", R.drawable.video_thumbnail1),
        VideoItem("Advanced Drone Maneuvers", R.drawable.video_thumbnail2),
        VideoItem("Drone Safety Guidelines", R.drawable.video_thumbnail3)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Light gray background
    ) {
        TopAppBar(
            title = { Text("Drone Videos") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Image(
                        painter = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
                        contentDescription = "Back"
                    )
                }
            },
            backgroundColor = Color(0xFF6200EE),
            contentColor = Color.White
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(videoList) { video ->
                VideoCard(videoItem = video, onClick = {
                    // Navigate to a video detail page or play the video
                    navController.navigate("video_detail/${video.title}")
                })
            }
        }
    }
}

@Composable
fun VideoCard(videoItem: VideoItem, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable { onClick() }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = videoItem.thumbnailRes),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(end = 8.dp)
        )
        Text(
            text = videoItem.title.take(25) + if (videoItem.title.length > 25) "..." else "",
            fontSize = 18.sp,
            modifier = Modifier.weight(1f)
        )

    }
}

data class VideoItem(
    val title: String,
    val thumbnailRes: Int
)

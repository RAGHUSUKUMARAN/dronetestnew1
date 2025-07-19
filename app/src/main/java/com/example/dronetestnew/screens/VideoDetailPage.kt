package com.example.dronetestnew.screens

import android.net.Uri
import android.widget.VideoView
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun VideoDetailPage(videoTitle: String?) {
    val context = LocalContext.current

    // Map video titles to raw resources
    val videoUri = when (videoTitle) {
        "Drone Basics" -> Uri.parse("android.resource://${context.packageName}/raw/video1")
        "Advanced Drone Maneuvers" -> Uri.parse("android.resource://${context.packageName}/raw/video2")
        "Drone Safety Guidelines" -> Uri.parse("android.resource://${context.packageName}/raw/video3")
        else -> null
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title Display
        Text(
            text = videoTitle ?: "Unknown Video",
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Video Playback
        if (videoUri != null) {
            AndroidView(
                factory = { context ->
                    VideoView(context).apply {
                        setVideoURI(videoUri)
                        start() // Start playing the video
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        } else {
            Text(
                text = "Video not found.",
                fontSize = 16.sp,
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Go Back Button
        Button(onClick = { /* Add back navigation here */ }) {
            Text(text = "Go Back")
        }
    }
}

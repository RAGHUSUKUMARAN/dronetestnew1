package com.example.dronetestnew.screens

import android.content.Context
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.github.barteksc.pdfviewer.PDFView

@Composable
fun PdfViewerPage(pdfFileName: String) {
    val context = LocalContext.current
    AndroidView(
        factory = { ctx ->
            PDFView(ctx, null).apply {
                layoutParams = FrameLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                fromAsset(pdfFileName).load()
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

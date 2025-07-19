package com.example.dronetestnew.models

/**
 * Represents a media item with a title and a URI.
 * Can be used for PDF, images, videos, and other media types.
 *
 * @param title The display title of the media item.
 * @param uri The URI or path to the media file.
 */
data class MediaItem(
    val title: String,
    val uri: String
)

package com.example.contentproviderapp.contentprovider

import android.net.Uri

data class AudioModel(
    val id: Long,
    val name: String,
    val artist: String,
    val uri: Uri
)

package com.example.contentproviderapp.presentation.audioscreen.state

import android.net.Uri

data class AudioState(
    val id: Long,
    val name: String,
    val artist: String,
    val uri: Uri
)

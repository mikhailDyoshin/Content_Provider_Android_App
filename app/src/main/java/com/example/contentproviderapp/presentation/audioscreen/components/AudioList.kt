package com.example.contentproviderapp.presentation.audioscreen.components

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contentproviderapp.presentation.audioscreen.state.AudioState

@Composable
fun AudioList(audios: List<AudioState>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
            .padding(top = 15.dp)
    )
    {
        audios.forEach {
            AudioItem(audio = it)
        }
        if (audios.isEmpty()) Text("No audios")
    }
}

@Preview
@Composable
fun AudioListPreview() {

    val audios = listOf(
        AudioState(
            id = 0L,
            name = "Smoke on the water",
            artist = "Deep Purple",
            uri = Uri.EMPTY
        ),
        AudioState(
            id = 1L,
            name = "Unforgiven",
            artist = "Metallica",
            uri = Uri.EMPTY
        ),
        AudioState(
            id = 2L,
            name = "New divide",
            artist = "Linkin Park",
            uri = Uri.EMPTY
        ), AudioState(
            id = 3L,
            name = "Paranoid",
            artist = "Black Sabbath",
            uri = Uri.EMPTY
        ), AudioState(
            id = 4L,
            name = "Rape me",
            artist = "Nirvana",
            uri = Uri.EMPTY
        ), AudioState(
            id = 5L,
            name = "Mutter",
            artist = "Rammstein",
            uri = Uri.EMPTY
        ), AudioState(
            id = 6L,
            name = "For whom the bell tolls",
            artist = "Metallica",
            uri = Uri.EMPTY
        )

    )

    AudioList(audios)
}
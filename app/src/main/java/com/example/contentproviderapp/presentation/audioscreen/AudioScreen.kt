package com.example.contentproviderapp.presentation.audioscreen

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contentproviderapp.presentation.audioscreen.components.AudioItem
import com.example.contentproviderapp.presentation.audioscreen.components.AudioList
import com.example.contentproviderapp.presentation.audioscreen.state.AudioState

@Composable
fun AudioScreen(audios: List<AudioState>, launchActivity: (input: String) -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AudioList(audios = audios)
        FloatingActionButton(
            onClick = { launchActivity("audio/*") },
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.End)
                .padding(end = 20.dp, bottom = 20.dp)
        ) {
            Text("+")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AudioScreenPreview() {

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

    AudioScreen(
        audios = audios,
        launchActivity = {}
    )
}

package com.example.contentproviderapp.presentation.audioscreen

import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
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
import com.example.contentproviderapp.presentation.audioscreen.state.AudioState

@Composable
fun AudioScreen(audios: List<AudioState>, launchActivity: (input: String) -> Unit) {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)) {
            audios.forEach {
                Column(modifier = Modifier.clickable {
                    Toast.makeText(context, it.uri.toString(), Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = it.name)
                    Text(text = it.artist)
                }
            }
            if (audios.isEmpty()) Text("No audios")
        }
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
        )
    )

    AudioScreen(
        audios = audios,
        launchActivity = {}
    )
}

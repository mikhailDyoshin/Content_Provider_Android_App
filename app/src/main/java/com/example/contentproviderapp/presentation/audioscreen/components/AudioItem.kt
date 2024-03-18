package com.example.contentproviderapp.presentation.audioscreen.components

import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contentproviderapp.presentation.audioscreen.state.AudioState
import com.example.contentproviderapp.ui.theme.Pink80

@Composable
fun AudioItem(audio: AudioState) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 2.dp)
            .background(color = Pink80, shape = RoundedCornerShape(size = 20.dp))
            .clickable {
                Toast
                    .makeText(context, audio.uri.toString(), Toast.LENGTH_SHORT)
                    .show()
            }) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = audio.name, fontSize = 16.sp)
            Text(text = audio.artist)
        }

    }
}

@Preview
@Composable
fun AudioItemPreview() {
    AudioItem(
        audio = AudioState(
            id = 0L,
            name = "Smoke on the water",
            artist = "Deep Purple",
            uri = Uri.EMPTY
        )
    )
}

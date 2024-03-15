package com.example.contentproviderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.contentproviderapp.presentation.audioscreen.AudioProviderViewModel
import com.example.contentproviderapp.presentation.audioscreen.state.AudioState
import com.example.contentproviderapp.ui.theme.ContentProviderAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContentProviderAppTheme {

                val viewModel = AudioProviderViewModel(applicationContext)

                val selectAudioLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.GetMultipleContents()
                ) { uriList ->
                    viewModel.getAudios(uriList)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                        audios = viewModel.audios.value,
                        launchActivity = { input -> selectAudioLauncher.launch(input) }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(audios: List<AudioState>, launchActivity: (input: String) -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column {
            audios.forEach {
                Column {
                    Text(text = it.name)
                    Text(text = it.artist)
                }
            }
            if (audios.isEmpty()) Text("No audios")
        }
        Button(
            onClick = { launchActivity("audio/*") },
            modifier = Modifier.wrapContentSize()
        ) {
            Text("Launch")
        }
    }
}

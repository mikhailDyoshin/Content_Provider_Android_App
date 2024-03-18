package com.example.contentproviderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.contentproviderapp.presentation.audioscreen.AudioProviderViewModel
import com.example.contentproviderapp.presentation.audioscreen.AudioScreen
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
                    AudioScreen(
                        audios = viewModel.audios.value,
                        launchActivity = { input -> selectAudioLauncher.launch(input) }
                    )
                }
            }
        }
    }
}



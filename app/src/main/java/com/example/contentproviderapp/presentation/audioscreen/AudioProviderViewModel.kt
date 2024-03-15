package com.example.contentproviderapp.presentation.audioscreen

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.contentproviderapp.contentprovider.AudioContentProvider
import com.example.contentproviderapp.presentation.audioscreen.state.AudioState

class AudioProviderViewModel(private val app: Context) : ViewModel() {

    private val _audios = mutableStateOf<List<AudioState>>(emptyList())

    val audios: State<List<AudioState>> = _audios

    private val audioContentProvider = AudioContentProvider(app)

    private val buffer: MutableList<AudioState> = mutableListOf()

    fun getAudios(uris: List<Uri>) {
        uris.forEach{uri ->
            val audioModel = audioContentProvider.getContent(uri)
            val audioState = AudioState(
                id = audioModel?.id ?: 1L,
                name = audioModel?.name ?: "No name",
                artist = audioModel?.artist ?: "No artist",
                uri = audioModel?.uri ?: Uri.EMPTY
            )
            buffer.add(audioState)
        }
        _audios.value = buffer.toList()
        buffer.clear()
    }

}
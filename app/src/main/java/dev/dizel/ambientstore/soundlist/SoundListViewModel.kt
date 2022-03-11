package dev.dizel.ambientstore.soundlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.dizel.ambientstore.Sound
import dev.dizel.ambientstore.stubSound
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.transform

class SoundListViewModel: ViewModel() {
    private val _soundList: MutableStateFlow<List<Sound>> = MutableStateFlow(emptyList())

    val state: StateFlow<SoundListViewState> = _soundList.map { soundList ->
        SoundListViewState(
            soundList = soundList
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = SoundListViewState.Empty
    )

    init {
        loadSoundList()
    }

    fun loadSoundList() {
        _soundList.value = stubSound
    }
}
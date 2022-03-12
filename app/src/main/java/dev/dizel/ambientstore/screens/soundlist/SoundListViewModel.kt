package dev.dizel.ambientstore.screens.soundlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.dizel.ambientstore.model.domain.entities.Sound
import dev.dizel.ambientstore.model.domain.repository.SoundRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SoundListViewModel @Inject constructor(
    private val repository: SoundRepository
): ViewModel() {
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
        viewModelScope.launch {
            _soundList.value = repository.getSoundList()
        }
    }
}
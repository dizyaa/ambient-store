package dev.dizel.ambientstore.screens.soundlist

import dev.dizel.ambientstore.model.domain.entities.Sound

data class SoundListViewState(
    val soundList: List<Sound>
) {
    companion object {
        val Empty = SoundListViewState(
            soundList = emptyList()
        )
    }
}
package dev.dizel.ambientstore.soundlist

import dev.dizel.ambientstore.Sound

data class SoundListViewState(
    val soundList: List<Sound>
) {
    companion object {
        val Empty = SoundListViewState(
            soundList = emptyList()
        )
    }
}
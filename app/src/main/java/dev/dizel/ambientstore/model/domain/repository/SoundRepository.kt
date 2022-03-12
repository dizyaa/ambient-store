package dev.dizel.ambientstore.model.domain.repository

import dev.dizel.ambientstore.model.domain.entities.Sound

interface SoundRepository {
    suspend fun getSoundList(): List<Sound>
}
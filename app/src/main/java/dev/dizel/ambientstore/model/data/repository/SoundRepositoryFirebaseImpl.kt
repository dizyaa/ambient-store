package dev.dizel.ambientstore.model.data.repository

import dev.dizel.ambientstore.model.domain.entities.Sound
import dev.dizel.ambientstore.model.domain.entities.stubSound
import dev.dizel.ambientstore.model.domain.repository.SoundRepository
import javax.inject.Inject

class SoundRepositoryFirebaseImpl @Inject constructor(): SoundRepository {

    override suspend fun getSoundList(): List<Sound> {
        return stubSound
    }

}
package dev.dizel.ambientstore.model.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import dev.dizel.ambientstore.model.domain.entities.Sound
import dev.dizel.ambientstore.model.domain.repository.SoundRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class SoundRepositoryFirebaseImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
): SoundRepository {

    override suspend fun getSoundList(): List<Sound> {
        return try {
            fireStore.collection("sounds")
                .get()
                .await()
                .mapNotNull {
                    Sound(
                        name = it.get("title", String::class.java) ?: return@mapNotNull null,
                        imageUrl = it.get("imageUrl", String::class.java) ?: return@mapNotNull null
                    )
                }
        } catch (ex: Exception) {
            emptyList()
        }
    }

}
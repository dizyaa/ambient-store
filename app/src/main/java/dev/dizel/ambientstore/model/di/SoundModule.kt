package dev.dizel.ambientstore.model.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.dizel.ambientstore.model.data.repository.SoundRepositoryFirebaseImpl
import dev.dizel.ambientstore.model.domain.repository.SoundRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface SoundModule {
    @Singleton
    @Binds
    fun provideSoundRepository(
        repositoryFirebaseImpl: SoundRepositoryFirebaseImpl
    ): SoundRepository
}
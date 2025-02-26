package com.onuryasarkaraduman.feature.detail.data.di

import com.onuryasarkaraduman.data.repository.BookDetailsRepositoryImpl
import com.onuryasarkaraduman.feature.detail.domain.repository.BookDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindBooksDetailRepository(repository: BookDetailsRepositoryImpl): BookDetailsRepository
}
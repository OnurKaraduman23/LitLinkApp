package com.onuryasarkaraduman.feature.search.data.di


import com.onuryasarkaraduman.feature.search.data.repository.SearchBooksRepositoryImpl

import com.onuryasarkaraduman.features.search.domain.repository.SearchBooksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindSearchBooksRepository(repository: SearchBooksRepositoryImpl): SearchBooksRepository
}
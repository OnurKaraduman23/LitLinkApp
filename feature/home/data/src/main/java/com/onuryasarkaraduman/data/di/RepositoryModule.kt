package com.onuryasarkaraduman.data.di

import com.onuryasarkaraduman.data.repository.HomeRepositoryImpl
import com.onuryasarkaraduman.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindHomeRepository(repository: HomeRepositoryImpl): HomeRepository
}
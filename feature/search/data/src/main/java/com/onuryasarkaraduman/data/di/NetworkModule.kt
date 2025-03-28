package com.onuryasarkaraduman.feature.search.data.di

import com.onuryasarkaraduman.data.source.SearchBooksApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideSearchBooksApiService(retrofit: Retrofit): SearchBooksApiService {
        return retrofit.create(SearchBooksApiService::class.java)
    }
}
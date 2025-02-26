package com.onuryasarkaraduman.feature.detail.data.di

import com.onuryasarkaraduman.data.source.BookDetailsApiService
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
    fun provideDetailsApiService(retrofit: Retrofit): BookDetailsApiService {
        return retrofit.create(BookDetailsApiService::class.java)
    }


}
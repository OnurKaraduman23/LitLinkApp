package com.onuryasarkaraduman.datastore.di

import android.content.Context
import com.onuryasarkaraduman.datastore.DataStoreHelper
import com.onuryasarkaraduman.datastore.DataStoreHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataStoreModule {

    @Provides
    @Singleton
    fun provideDataStoreHelper(
        @ApplicationContext context: Context,
    ): DataStoreHelper = DataStoreHelperImpl(context)

}
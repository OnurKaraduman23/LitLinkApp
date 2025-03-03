package com.onuryasarkaraduman.network.di

import com.google.firebase.firestore.FirebaseFirestore
import com.onuryasarkaraduman.firestore.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FirestoreRepositoryModule {


    @Binds
    abstract fun bindUserRepository(repositoryImpl: UserRepositoryImpl): FirebaseFirestore
}
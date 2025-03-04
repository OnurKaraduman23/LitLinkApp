package com.onuryasarkaraduman.network.di

import com.onuryasarkaraduman.auth.FirebaseAuthRepository
import com.onuryasarkaraduman.auth.FirerebaseAuthRepositoryImpl
import com.onuryasarkaraduman.firestore.UserRepository
import com.onuryasarkaraduman.firestore.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseRepositoryModule {


    @Binds
    abstract fun bindUserRepository(firestoreRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindFirebaseAuthRepository(authRepositoryImpl: FirerebaseAuthRepositoryImpl): FirebaseAuthRepository
}
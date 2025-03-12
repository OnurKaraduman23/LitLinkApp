package com.onuryasarkaraduman.network.di

import com.onuryasarkaraduman.auth.FirebaseAuthRepository
import com.onuryasarkaraduman.auth.FirerebaseAuthRepositoryImpl
import com.onuryasarkaraduman.firestore.books.BookRepository
import com.onuryasarkaraduman.firestore.books.BookRepositoryImpl
import com.onuryasarkaraduman.firestore.user.UserRepository
import com.onuryasarkaraduman.firestore.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseRepositoryModule {


    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindBooksRepository(booksRepositoryImpl: BookRepositoryImpl): BookRepository

    @Binds
    abstract fun bindFirebaseAuthRepository(authRepositoryImpl: FirerebaseAuthRepositoryImpl): FirebaseAuthRepository
}
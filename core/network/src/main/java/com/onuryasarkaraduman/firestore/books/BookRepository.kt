package com.onuryasarkaraduman.firestore.books

import com.google.android.gms.tasks.Task
import com.onuryasarkaraduman.datasource.user.CompletedBooks
import com.onuryasarkaraduman.datasource.user.PlannedBooks
import com.onuryasarkaraduman.datasource.user.ReadingBooks
import com.onuryasarkaraduman.datasource.user.ReadingStatus

interface BookRepository {
    fun addCompleteBook(userId: String, completedBooks: CompletedBooks): Task<Void>
    fun addPlannedBooks(userId: String, plannedBooks: PlannedBooks): Task<Void>
    fun addReadingBook(userId: String, currentReadingBooks: ReadingBooks): Task<Void>
    suspend fun checkAddedUserBook(userId: String, bookId: String): ReadingStatus
    suspend fun hasUserAddedAnyBooks(userId: String): Boolean
}
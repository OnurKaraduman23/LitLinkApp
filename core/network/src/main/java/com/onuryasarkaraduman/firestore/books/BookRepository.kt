package com.onuryasarkaraduman.firestore.books

import com.google.android.gms.tasks.Task
import com.onuryasarkaraduman.datasource.user.CompletedBooks
import com.onuryasarkaraduman.datasource.user.PlannedBooks
import com.onuryasarkaraduman.datasource.user.ReadingBooks
import com.onuryasarkaraduman.datasource.user.User

interface BookRepository {
    fun addCompleteBook(currentUser: User, completedBooks: CompletedBooks): Task<Void>
    fun addPlannedBooks(currentUser: User, plannedBooks: PlannedBooks): Task<Void>
    fun addReadingBook(currentUser: User, currentReadingBooks: ReadingBooks): Task<Void>
}
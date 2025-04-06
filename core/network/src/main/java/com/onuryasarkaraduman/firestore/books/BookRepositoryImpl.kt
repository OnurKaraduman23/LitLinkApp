package com.onuryasarkaraduman.firestore.books

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.onuryasarkaraduman.datasource.user.CompletedBooks
import com.onuryasarkaraduman.datasource.user.PlannedBooks
import com.onuryasarkaraduman.datasource.user.ReadingBooks
import com.onuryasarkaraduman.datasource.user.ReadingStatus
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
) : BookRepository {
    override fun addCompleteBook(
        userId: String,
        completedBooks: CompletedBooks,
    ): Task<Void> {
        val userRef = firestore.collection("users").document(userId)

        // Önce mevcut kullanıcı dökümanını alıyoruz
        return userRef.get().continueWithTask { task ->
            val userDoc = task.result
            if (userDoc != null && userDoc.exists()) {
                // Şu anki Books nesnesini alıyoruz veya yoksa yeni oluşturuyoruz
                val currentBooks = userDoc.get("books") as? Map<String, Any>

                // Mevcut completedBooks listesini alıyoruz
                @Suppress("UNCHECKED_CAST")
                val completedBooksList = currentBooks?.get("completedBooks") as? List<Map<String, Any>> ?: listOf()

                // Kitap zaten listede var mı kontrol ediyoruz
                val bookExists = completedBooksList.any { it["bookId"] == completedBooks.bookId }
                if (bookExists) {
                    throw Exception("This book is already on the list of books already read.")
                }

                // Kitabı books.completedBooks dizisine ekliyoruz
                return@continueWithTask userRef.update(
                    "books.completedBooks",
                    FieldValue.arrayUnion(completedBooks)
                )
            } else {
                // Kullanıcı bulunamadı
                throw Exception("User not found")
            }
        }
    }

    override fun addPlannedBooks(
        userId: String,
        plannedBooks: PlannedBooks,
    ): Task<Void> {
        val userRef = firestore.collection("users").document(userId)

        return userRef.get().continueWithTask { task ->
            val userDoc = task.result
            if (userDoc != null && userDoc.exists()) {
                val currentBooks = userDoc.get("books") as? Map<String, Any>

                @Suppress("UNCHECKED_CAST")
                val plannedBooksList = currentBooks?.get("plannedBooks") as? List<Map<String, Any>> ?: listOf()

                val bookExists = plannedBooksList.any { it["bookId"] == plannedBooks.bookId }
                if (bookExists) {
                    throw Exception("This book is already on the list of books planned to be read.")
                }

                return@continueWithTask userRef.update(
                    "books.plannedBooks",
                    FieldValue.arrayUnion(plannedBooks)
                )
            } else {
                throw Exception("User not found")
            }
        }
    }

    override fun addReadingBook(
        userId: String,
        currentReadingBooks: ReadingBooks,
    ): Task<Void> {
        val userRef = firestore.collection("users").document(userId)

        return userRef.get().continueWithTask { task ->
            val userDoc = task.result
            if (userDoc != null && userDoc.exists()) {
                val currentBooks = userDoc.get("books") as? Map<String, Any>

                @Suppress("UNCHECKED_CAST")
                val readingBooksList = currentBooks?.get("readingBooks") as? List<Map<String, Any>> ?: listOf()

                val bookExists = readingBooksList.any { it["bookId"] == currentReadingBooks.bookId }
                if (bookExists) {
                    throw Exception("This book is already on my list of books to read.")
                }

                return@continueWithTask userRef.update(
                    "books.readingBooks",
                    FieldValue.arrayUnion(currentReadingBooks)
                )
            } else {
                throw Exception("User not found")
            }
        }
    }

    override suspend fun checkAddedUserBook(
        userId: String,
        bookId: String,
    ): ReadingStatus {
        val userRef = firestore.collection("users").document(userId)
        val snapshot = userRef.get().await()
        if (snapshot.exists()) {
            val booksMap = snapshot.get("books") as? Map<String, Any>
            booksMap?.let { map ->
                // CompletedBooks kontrolü
                val completedBooks = map["completedBooks"] as? List<Map<String, Any>> ?: emptyList()
                if (completedBooks.any { it["bookId"] == bookId }) {
                    return ReadingStatus.READ
                }
                // PlannedBooks kontrolü
                val plannedBooks = map["plannedBooks"] as? List<Map<String, Any>> ?: emptyList()
                if (plannedBooks.any { it["bookId"] == bookId }) {
                    return ReadingStatus.WILL_READ
                }
                // ReadingBooks kontrolü
                val readingBooks = map["readingBooks"] as? List<Map<String, Any>> ?: emptyList()
                if (readingBooks.any { it["bookId"] == bookId }) {
                    return ReadingStatus.READING
                }
            }
        }
        return ReadingStatus.NONE
    }

    override suspend fun hasUserAddedAnyBooks(userId: String): Boolean {
        val userRef = firestore.collection("users").document(userId)
        val snapshot = userRef.get().await()

        if (snapshot.exists()) {
            val booksMap = snapshot.get("books") as? Map<String, Any>

            booksMap?.let { map ->
                // CompletedBooks kontrolü
                val completedBooks = map["completedBooks"] as? List<Map<String, Any>> ?: emptyList()
                if (completedBooks.isNotEmpty()) {
                    return true
                }

                // PlannedBooks kontrolü
                val plannedBooks = map["plannedBooks"] as? List<Map<String, Any>> ?: emptyList()
                if (plannedBooks.isNotEmpty()) {
                    return true
                }

                // ReadingBooks kontrolü
                val readingBooks = map["readingBooks"] as? List<Map<String, Any>> ?: emptyList()
                if (readingBooks.isNotEmpty()) {
                    return true
                }
            }
        }

        return false
    }


}
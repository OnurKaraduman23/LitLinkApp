package com.onuryasarkaraduman.firestore.books

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.onuryasarkaraduman.datasource.user.CompletedBooks
import com.onuryasarkaraduman.datasource.user.PlannedBooks
import com.onuryasarkaraduman.datasource.user.ReadingBooks
import com.onuryasarkaraduman.datasource.user.User
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
) : BookRepository {
    override fun addCompleteBook(
        currentUser: User,
        completedBooks: CompletedBooks,
    ): Task<Void> {
        val collectionRef = firestore.collection("users")
            .document(currentUser.uid)
            .collection("completedBooks")
        val docRef = collectionRef.document(completedBooks.bookId)

        return docRef.get().continueWithTask { task ->
            val document = task.result
            if (document != null && document.exists()) {
                throw Exception("Bu kitap zaten tamamlanmış kitaplar listesinde mevcut.")
            } else {
                docRef.set(completedBooks)
            }
        }
    }

    override fun addPlannedBooks(
        currentUser: User,
        plannedBooks: PlannedBooks,
    ): Task<Void> {
        val collectionRef = firestore.collection("users")
            .document(currentUser.uid)
            .collection("plannedBooks")
        val docRef = collectionRef.document(plannedBooks.bookId)

        return docRef.get().continueWithTask { task ->
            val document = task.result
            if (document != null && document.exists()) {
                throw Exception("Bu kitap zaten planlanmış kitaplar listesinde mevcut.")
            } else {
                docRef.set(plannedBooks)
            }
        }
    }

    override fun addReadingBook(
        currentUser: User,
        currentReadingBooks: ReadingBooks,
    ): Task<Void> {
        val collectionRef = firestore.collection("users")
            .document(currentUser.uid)
            .collection("readingBooks")
        val docRef = collectionRef.document(currentReadingBooks.bookId)

        return docRef.get().continueWithTask { task ->
            val document = task.result
            if (document != null && document.exists()) {
                throw Exception("Bu kitap zaten okuma kitapları listesinde mevcut.")
            } else {
                docRef.set(currentReadingBooks)
            }
        }

    }

}
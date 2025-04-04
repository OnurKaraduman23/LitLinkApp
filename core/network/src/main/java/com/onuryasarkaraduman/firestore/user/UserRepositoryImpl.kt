package com.onuryasarkaraduman.firestore.user

import com.google.firebase.firestore.FirebaseFirestore
import com.onuryasarkaraduman.common.BaseException
import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.datasource.user.User
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
) : UserRepository {

    override suspend fun saveUser(user: User): Resource<Unit> {
        return try {

            val docRef = firestore.collection("users").document(user.uid)
            val snapshot = docRef.get().await()

            if (snapshot.exists()) {
                throw BaseException("User with uid ${user.uid} already exists")
            }

            docRef.set(user).await()

            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(BaseException(e.message ?: "An unexpected error occurred"))
        }
    }

    override suspend fun getUsernameById(userId: String?): String {
        val db = FirebaseFirestore.getInstance()
        var username = ""

        if (userId != null) {
            // Kullanıcının UID'sini kullanarak Firestore'dan bilgilerini çek
            db.collection("users").document(userId)
                .get()
                .addOnSuccessListener { document ->
                    if (document != null && document.exists()) {
                        // Dökümanı User sınıfına dönüştür
                        val user = document.toObject(User::class.java)
                        // userName'i al
                        username = user?.userName ?: ""
                    }
                }
                .addOnFailureListener { exception ->
                    println("Error getting user: $exception")
                }
        }

        return username
    }


}
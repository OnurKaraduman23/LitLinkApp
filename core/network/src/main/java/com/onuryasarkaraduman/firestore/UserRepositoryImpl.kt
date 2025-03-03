package com.onuryasarkaraduman.firestore

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


}
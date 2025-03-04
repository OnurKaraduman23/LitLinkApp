package com.onuryasarkaraduman.auth

import com.google.firebase.auth.FirebaseAuth
import com.onuryasarkaraduman.common.BaseException
import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.datasource.user.User
import com.onuryasarkaraduman.firestore.UserRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirerebaseAuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val userRepository: UserRepository,
) : FirebaseAuthRepository {

    override suspend fun signUp(
        email: String,
        password: String,
        userName: String,
    ): Resource<String> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val userId = result.user?.uid
            userId?.let {
                val user = User(
                    uid = userId,
                    userName = userName,
                    email = email,
                )
                userRepository.saveUser(user = user)
            }
            Resource.Success(userId!!)
        } catch (e: BaseException) {
            Resource.Error(e)
        }
    }

    override fun isUserLoggedIn(): Boolean = auth.currentUser != null
    override fun signOut() = auth.signOut()


}

package com.onuryasarkaraduman.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.onuryasarkaraduman.common.BaseException
import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.datasource.user.User
import com.onuryasarkaraduman.firestore.user.UserRepository
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
                ?: return Resource.Error(BaseException("Failed to retrieve user ID."))

            val user = User(
                uid = userId,
                userName = userName,
                email = email,
            )

            userRepository.saveUser(user = user)

            Resource.Success(userId)
        } catch (e: FirebaseAuthUserCollisionException) {
            Resource.Error(BaseException("This email address is already in use."))
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Resource.Error(BaseException("Invalid email format. Please enter a valid email address."))
        } catch (e: FirebaseAuthException) {
            Resource.Error(BaseException("Authentication error: ${e.message}"))
        } catch (e: Exception) {
            Resource.Error(BaseException("Unknown error: ${e.message}"))
        }
    }


    override suspend fun signIn(
        email: String,
        password: String,
    ): Resource<String> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user?.email.orEmpty())
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Resource.Error(BaseException("Username or password incorrect"))
        } catch (e: FirebaseAuthException) {
            Resource.Error(BaseException("Authentication failure: ${e.message}"))
        } catch (e: Exception) {
            Resource.Error(BaseException("Unknown Error: ${e.message}"))
        }
    }

    override fun isUserLoggedIn(): Boolean = auth.currentUser != null
    override fun signOut() = auth.signOut()


}

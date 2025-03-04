package com.onuryasarkaraduman.auth

import com.onuryasarkaraduman.common.Resource

interface FirebaseAuthRepository {
    suspend fun signUp(email: String, password: String, userName: String): Resource<String>
    fun isUserLoggedIn(): Boolean
    fun signOut()
}
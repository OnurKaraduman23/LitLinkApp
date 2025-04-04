package com.onuryasarkaraduman.firestore.user


import android.R
import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.datasource.user.User


interface UserRepository {
    suspend fun saveUser(user: User): Resource<Unit>
    suspend fun getUsernameById(userId: String?): String
}
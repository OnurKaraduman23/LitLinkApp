package com.onuryasarkaraduman.firestore.user


import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.datasource.user.User


interface UserRepository {
    suspend fun saveUser(user: User): Resource<Unit>
}
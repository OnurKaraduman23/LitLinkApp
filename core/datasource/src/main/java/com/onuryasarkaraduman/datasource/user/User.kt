package com.onuryasarkaraduman.datasource.user

data class User(
    val uid: String = "",
    val userName: String = "",
    val email: String = "",
    val books: Books? = null,
    val friends:Friend? = null
)

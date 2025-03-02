package com.onuryasarkaraduman.datasource.user

data class Friend(
    val friendUid: String = "",
    val since: Long = System.currentTimeMillis(),
    val status: FriendshipStatus = FriendshipStatus.PENDING
)

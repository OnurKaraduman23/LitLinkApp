package com.onuryasarkaraduman.datasource.user

data class Friend(
    val friendUid: String = "",
    val userName: String = "",
    val since: Long = System.currentTimeMillis(),
    val status: FriendshipStatus = FriendshipStatus.PENDING,
    val relatedBooks: List<RelatedBooks?> = emptyList()
)
// userName , image eklenebilir.
package com.onuryasarkaraduman.datasource.user.mapper

import com.onuryasarkaraduman.datasource.user.Friend
import com.onuryasarkaraduman.datasource.user.FriendshipStatus

fun Friend.toFirestore(): Map<String, Any?> {
    return mapOf(
        "friendUid" to friendUid,
        "since" to since,
        "status" to status.name
    )
}

fun Map<String, Any?>.toFriend(): Friend? {
    return Friend(
        friendUid = this["friendUid"] as? String ?: "",
        since = this["since"] as? Long ?: System.currentTimeMillis(),
        status = FriendshipStatus.fromString(this["status"] as? String)
    )
}

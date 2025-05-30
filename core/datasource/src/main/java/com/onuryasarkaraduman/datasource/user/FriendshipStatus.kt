package com.onuryasarkaraduman.datasource.user

enum class FriendshipStatus {
    PENDING, ACCEPTED, REJECTED, BLOCKED,NONE;

    companion object {
        fun fromString(value: String?): FriendshipStatus {
            return values().find { it.name == value } ?: PENDING
        }
    }
}


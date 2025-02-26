package com.onuryasarkaraduman.common

fun Int?.orZero() = this ?: 0

fun Double?.orZero() = this ?: 0.0
fun Float?.orZero() = this ?: 0.0f

fun Boolean?.orFalse() = this ?: false
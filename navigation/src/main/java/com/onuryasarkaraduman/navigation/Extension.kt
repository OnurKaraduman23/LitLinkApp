package com.onuryasarkaraduman.navigation

import com.onuryasarkaraduman.ui.navigation.Screen

fun Screen.getRoute(): String {
    return this::class.java.canonicalName.orEmpty()
}
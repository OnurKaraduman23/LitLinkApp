package com.onuryasarkaraduman.connectivity

import kotlinx.coroutines.flow.Flow

interface ConnectivityListener {
    val isNetworkAvailable: Flow<Boolean>
}
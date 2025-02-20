package com.onuryasarkaraduman.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreHelper {
    suspend fun saveCategories(userSelectedCategoriesList: List<String>)
    fun getUserCategories(): Flow<List<String>>
}
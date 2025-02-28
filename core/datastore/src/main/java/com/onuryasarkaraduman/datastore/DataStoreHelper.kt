package com.onuryasarkaraduman.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreHelper {
    suspend fun saveCategories(userSelectedCategoriesList: List<String>)
    suspend fun saveOnboardingShowState(isShowState: Boolean)
    fun getUserCategories(): Flow<List<String>>
    fun getOnboardingState(): Flow<Boolean>
}
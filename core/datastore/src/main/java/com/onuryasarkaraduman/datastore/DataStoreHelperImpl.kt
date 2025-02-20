package com.onuryasarkaraduman.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.onuryasarkaraduman.datastore.PreferencesKeys.CATEGORIES_LIST
import com.onuryasarkaraduman.datastore.PreferencesKeys.STORE_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DataStoreHelperImpl @Inject constructor(private val context: Context) :
    DataStoreHelper {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(STORE_NAME)
    override suspend fun saveCategories(userSelectedCategoriesList: List<String>) {
        context.dataStore.edit { preferences ->
            preferences[CATEGORIES_LIST] = userSelectedCategoriesList.toSet().joinToString(",")
        }
    }

    override fun getUserCategories(): Flow<List<String>> {
        return context.dataStore.data.map { preferences ->
            preferences[CATEGORIES_LIST]?.split(",") ?: emptyList()
        }
    }
}
package com.onuryasarkaraduman.datastore

import androidx.datastore.preferences.core.stringPreferencesKey

internal object PreferencesKeys {
    const val STORE_NAME = "litlink_data_store"
    val CATEGORIES_LIST = stringPreferencesKey("categoriesSet")
}
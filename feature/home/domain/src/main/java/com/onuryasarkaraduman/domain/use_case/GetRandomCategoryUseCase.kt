package com.onuryasarkaraduman.domain.use_case

import javax.inject.Inject

class GetRandomCategoryUseCase @Inject constructor() {
    fun execute(categories: List<String>): String {
        require(categories.isNotEmpty()) { "Categories list cannot be empty" }
        return categories.random()
    }
}
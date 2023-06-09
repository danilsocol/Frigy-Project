package com.example.domain.models

import com.example.domain.dto.ProductStorageRequest

data class Recipe(
    val name: String,
    val description : String,
    val categoryRecipe: Int,
    val productList : List<Ingredient>
)
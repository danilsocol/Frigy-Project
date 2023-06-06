package com.example.data.models

data class RecipeRequest(
    val name: String,
    val description : String,
    val categoryRecipe: Int,
    val productList : List<ProductRequest>
)
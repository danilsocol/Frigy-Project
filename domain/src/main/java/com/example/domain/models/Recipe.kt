package com.example.domain.models

data class Recipe(
    val name: String,
    val description : String,
    val categoryRecipe: Int,
    val productList : List<Product>
)
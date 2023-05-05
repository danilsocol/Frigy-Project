package com.example.frigy_project.models

data class Recipe(
    val id: Int,
    val name: String,
    val categoryRecipe: Int,
    val productList : List<Product>
)
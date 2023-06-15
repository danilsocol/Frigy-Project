package com.example.domain.dto

interface RecipeRequest {
    val title: String
    val description : String
    val recipeCategory: Int
    val productList : List<ProductRequest>
}
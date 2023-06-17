package com.example.domain.dto

interface RecipeRequest {
    val id : Int
    val title: String
    val description : String
    val recipeCategory: Int
    val productList : List<ProductRequest>
}
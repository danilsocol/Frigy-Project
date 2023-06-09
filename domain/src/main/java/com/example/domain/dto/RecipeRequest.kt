package com.example.domain.dto

import com.example.domain.models.Ingredient

interface RecipeRequest {
    val title: String
    val description : String
    val recipeCategory: Int
    val productList : List<Ingredient>
}
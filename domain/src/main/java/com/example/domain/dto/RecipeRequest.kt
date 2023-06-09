package com.example.domain.dto

import com.example.domain.models.Ingredient

interface RecipeRequest {
    val name: String
    val description : String
    val categoryRecipe: Int
    val productList : List<Ingredient>
}
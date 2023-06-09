package com.example.domain.repository

import com.example.domain.dto.RecipeRequest
import com.example.domain.models.Recipe

interface RecipeRepository {

    suspend fun getRecipeById(id: String): RecipeRequest

    suspend fun getAllRecipes(): List<RecipeRequest>

/*    suspend fun createRecipe(recipe: Recipe): Recipe*/
}
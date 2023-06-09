package com.example.domain.repository

import com.example.domain.dto.RecipeRequest
import com.example.domain.models.Recipe

interface RecipeRepository {

    suspend fun getRecipeById(id: String): Recipe

    suspend fun getAllRecipes(): List<Recipe>

/*    suspend fun createRecipe(recipe: Recipe): Recipe*/
}
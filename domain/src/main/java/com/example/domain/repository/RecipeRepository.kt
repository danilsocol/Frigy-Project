package com.example.domain.repository

import com.example.domain.dto.RecipeCreate
import com.example.domain.models.Recipe

interface RecipeRepository {

    suspend fun getRecipeById(id: Int) : Recipe

    suspend fun getAllRecipes(): List<Recipe>

    suspend fun createRecipe(recipe: RecipeCreate)
}
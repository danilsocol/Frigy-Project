package com.example.frigy_project.api

import com.example.frigy_project.api.request.RecipeRequest
import com.example.frigy_project.dtos.Recipe

class RecipeRepository {

    private val retrofit = RetrofitBuilder.getClient()
    private val recipeApi = retrofit!!.create(RecipeAPI::class.java)
    suspend fun getRecipeById(id: String): Recipe {
        return recipeApi.getRecipeById(id)
    }

    suspend fun getAllRecipes(): List<Recipe> {
        return recipeApi.getAllRecipes()
    }

    suspend fun createRecipe(recipeRecipe: RecipeRequest): Recipe {
        return recipeApi.createRecipe(recipeRecipe)
    }

}
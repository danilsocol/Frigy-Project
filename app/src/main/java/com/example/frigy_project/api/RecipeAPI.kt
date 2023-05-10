package com.example.frigy_project.api

import com.example.frigy_project.api.request.RecipeRequest
import com.example.frigy_project.models.Product
import com.example.frigy_project.models.Recipe
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RecipeAPI {
    @GET("recipes/{id}")
    suspend fun getRecipeById(@Path("id") id : String) : Recipe //todo id string

    @GET("recipes")
    suspend fun getAllRecipes() : List<Recipe>

    @POST("recipes")
    suspend fun createRecipe(@Body recipeRequest: RecipeRequest) : Recipe

}
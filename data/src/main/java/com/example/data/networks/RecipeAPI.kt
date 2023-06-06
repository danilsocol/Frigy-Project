package com.example.data.networks


import com.example.data.models.RecipeRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RecipeAPI {
    @GET("recipes/{id}")
    suspend fun getRecipeById(@Path("id") id : String) : RecipeRequest //todo id string

    @GET("recipes")
    suspend fun getAllRecipes() : List<RecipeRequest>

    @POST("recipes")
    suspend fun createRecipe(@Body recipe: RecipeRequest) : RecipeRequest

}
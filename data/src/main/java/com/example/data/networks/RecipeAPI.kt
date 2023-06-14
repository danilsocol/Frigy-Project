package com.example.data.networks


import com.example.data.models.RecipeRequestImpl
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RecipeAPI {
    @GET("recipes/{id}")
    suspend fun getRecipeById(@Path("id") id : String) : RecipeRequestImpl //todo id string

    @GET("recipes")
    fun getAllRecipes() : List<RecipeRequestImpl>

  /*  @POST("recipes")
    suspend fun createRecipe(@Body recipe: RecipeRequestImpl) : RecipeRequestImpl*/

}
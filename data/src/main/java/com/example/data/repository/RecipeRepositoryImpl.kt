package com.example.data.repository

import com.example.data.models.ProductRequestImpl
import com.example.data.models.RecipeRequestImpl
import com.example.data.networks.RecipeAPI
import com.example.domain.dto.RecipeCreate
import com.example.domain.dto.RecipeRequest
import com.example.domain.models.Recipe
import com.example.domain.repository.RecipeRepository
import javax.inject.Inject


class RecipeRepositoryImpl @Inject constructor(private val recipeApi : RecipeAPI) : RecipeRepository {

    override suspend fun getRecipeById(id: Int): Recipe {
        val recipe = recipeApi.getRecipeById(id)
        return Recipe.getRecipe(recipe)
    }

    override suspend fun getAllRecipes(): List<Recipe> {
        return Recipe.getAllRecipe(recipeApi.getAllRecipes())
    }

    override suspend fun createRecipe(recipe: RecipeCreate) {
        val mapRecipe = RecipeRequestImpl(Recipe.getNewId(),recipe.title,recipe.description,recipe.recipeCategory,
            recipe.productList.map { product -> ProductRequestImpl(product) })
        recipeApi.createRecipe(mapRecipe)
    }

}
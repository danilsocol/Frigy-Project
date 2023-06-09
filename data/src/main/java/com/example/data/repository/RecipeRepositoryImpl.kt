package com.example.data.repository

import com.example.data.models.RecipeRequestImpl
import com.example.data.networks.RecipeAPI
import com.example.data.retrofit.RetrofitBuilder
import com.example.domain.models.Recipe
import com.example.domain.repository.RecipeRepository


class RecipeRepositoryImpl : RecipeRepository { // todo убрать дублирование кода

    private val retrofit = RetrofitBuilder.getClient()
    private val recipeApi = retrofit!!.create(RecipeAPI::class.java)
    override suspend fun getRecipeById(id: String): Recipe {
        val recipe = recipeApi.getRecipeById(id)
        return Recipe.getRecipe(recipe)
    }

    override suspend fun getAllRecipes(): List<Recipe> {
        return Recipe.getAllRecipe(recipeApi.getAllRecipes())
    }

    /*override suspend fun createRecipe(recipe: Recipe): Recipe {
        val mapRecipe = RecipeRequest(recipe.name,recipe.description,recipe.categoryRecipe,
            recipe.productList.map { product -> ProductStorageRequestImpl(product.title,product.productCategory,
                product.isImportant,product.count,product.maxCount) })
        val result = recipeApi.createRecipe(mapRecipe)
        return Recipe(result.name,result.description,result.categoryRecipe,
            result.productList.map { product -> ProductStorageRequestImpl(product.title,product.productCategory,product.isImportant,
                product.countStorage,product.maxCountStorage) })
    }*/
}
package com.example.data.repository

import com.example.data.models.ProductStorageRequestImpl
import com.example.data.models.RecipeRequestImpl
import com.example.data.networks.RecipeAPI
import com.example.data.retrofit.RetrofitBuilder
import com.example.domain.models.Recipe
import com.example.domain.repository.RecipeRepository


class RecipeRepositoryImpl : RecipeRepository { // todo убрать дублирование кода

    private val retrofit = RetrofitBuilder.getClient()
    private val recipeApi = retrofit!!.create(RecipeAPI::class.java)
    override suspend fun getRecipeById(id: String): RecipeRequestImpl {
        val recipe = recipeApi.getRecipeById(id)
        return RecipeRequestImpl(recipe.name,recipe.description,recipe.categoryRecipe,
            recipe.productList)
    }

    override suspend fun getAllRecipes(): List<RecipeRequestImpl> {
        return recipeApi.getAllRecipes().map { recipe -> RecipeRequestImpl(recipe.name,recipe.description,recipe.categoryRecipe,
            recipe.productList) }
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
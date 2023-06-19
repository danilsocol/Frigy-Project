package com.example.data.repository

import com.example.data.models.ProductRequestImpl
import com.example.data.models.RecipeRequestImpl
import com.example.data.networks.RecipeAPI
import com.example.domain.dto.RecipeCreate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.models.Recipe
import com.example.domain.models.RecipeCategory
import com.example.domain.repository.RecipeRepository
import javax.inject.Inject


class RecipeRepositoryImpl @Inject constructor(private val recipeApi: RecipeAPI) :
    RecipeRepository {

    override suspend fun getRecipeById(id: Int): Recipe {
        try {
            val recipe = recipeApi.getRecipeById(id)
            return Recipe.getRecipe(recipe)
        } catch (e: Exception) {
            return Recipe(
                0, "Суп с молоком", "Описания пока что нет", RecipeCategory(1, "Суп"),
                listOf(
                    Product.DefaultProduct(0, "Молоко", ProductCategory(0, "Жидкость", "литр"), 1),
                    Product.DefaultProduct(
                        1,
                        "Креветки",
                        ProductCategory(0, "Жидкость", "литр"),
                        1
                    ),
                )
            )
        }
    }

    override suspend fun getAllRecipes(): List<Recipe> {
        try {
            return Recipe.getAllRecipe(recipeApi.getAllRecipes())
        } catch (e: Exception) {
            Product.Factory.countProduct = 0
            return listOf<Recipe>(
                Recipe(
                    0, "Суп с молоком", "рецепт", RecipeCategory(1, "Суп"),
                    listOf(
                        Product.DefaultProduct(
                            0,
                            "Молоко",
                            ProductCategory(0, "Жидкость", "литр"),
                            1
                        ),
                        Product.DefaultProduct(
                            1,
                            "Креветки",
                            ProductCategory(0, "Жидкость", "литр"),
                            1
                        ),
                    )
                )
            )
        }
    }

    override suspend fun createRecipe(recipe: RecipeCreate) {
        try {
            val mapRecipe = RecipeRequestImpl(Recipe.getNewId(),
                recipe.title,
                recipe.description,
                recipe.recipeCategory,
                recipe.productList.map { product -> ProductRequestImpl(product) })
            recipeApi.createRecipe(mapRecipe)
        } catch (e: Exception) {

        }
    }

}
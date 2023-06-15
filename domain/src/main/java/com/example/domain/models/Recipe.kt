package com.example.domain.models

import com.example.domain.dto.RecipeRequest

data class Recipe(
    override val title: String,
    val description : String,
    val recipeCategory: RecipeCategory,
    val productList : List<Product>
) : IFilterable {
    companion object Factory {
        val recipeCategoryList  =  listOf(
            (RecipeCategory(1, "Салат")),
            (RecipeCategory(2, "Основное")),
            (RecipeCategory(3, "Суп"))
        )
        fun getRecipe(res: RecipeRequest): Recipe{

            return Recipe(res.title,res.description, recipeCategoryList[res.recipeCategory],
                res.productList.map { product -> Product.getProduct(product) })
        }

        fun getAllRecipe(res: List<RecipeRequest>): List<Recipe>{
            return res.map { getRecipe(it) }
        }
    }
}
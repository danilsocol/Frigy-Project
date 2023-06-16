package com.example.domain.models

import com.example.domain.dto.RecipeRequest

data class Recipe(
    override val title: String,
    val description : String,
    val recipeCategory: RecipeCategory,
    val productList : List<Product>) : IFilterable
{
    constructor(title: String, description: String, recipeCategory: Int, productList : List<Product> ) : this(
        title, description, recipeCategoryList[recipeCategory] , productList
    )
    companion object Factory {
        val recipeCategoryList  =  listOf(
            (RecipeCategory(0, "Основное")),
            (RecipeCategory(1, "Суп")),
            (RecipeCategory(2, "Салат"))
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
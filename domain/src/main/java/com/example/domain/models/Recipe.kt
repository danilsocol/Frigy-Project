package com.example.domain.models

import com.example.domain.dto.RecipeCreate
import com.example.domain.dto.RecipeRequest

data class Recipe(
    val id : Int,
    override val title: String,
    val description : String,
    val recipeCategory: RecipeCategory,
    val productList : List<Product>) : IFilterable
{
    constructor(id: Int,title: String, description: String, recipeCategory: Int, productList : List<Product> ) : this( id,
        title, description, recipeCategoryList[recipeCategory] , productList
    )
    companion object Factory {
        var countRecipe : Int = 0 // todo нужен для id переделать в guid

        val recipeCategoryList  =  listOf(
            (RecipeCategory(0, "Основное")),
            (RecipeCategory(1, "Суп")),
            (RecipeCategory(2, "Салат"))
        )
        fun getRecipe(res: RecipeRequest): Recipe{
            countRecipe++
            return Recipe(res.id,res.title,res.description, recipeCategoryList[res.recipeCategory],
                res.productList.map { recipe -> Product.getProduct(recipe) })

        }

        fun getRecipe(res: RecipeCreate): Recipe{
            countRecipe++
            return Recipe(countRecipe,res.title,res.description, recipeCategoryList[res.recipeCategory],
                res.productList)
        }

        fun getAllRecipe(res: List<RecipeRequest>): List<Recipe>{
            return res.map { getRecipe(it) }
        }
    }
}
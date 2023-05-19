package com.example.frigy_project.dtos

data class Recipe(
    override val id: Int,
    override val name: String,
    val categoryRecipe: RecipeCategory,
    val productList : List<Product>
) : IFilterable
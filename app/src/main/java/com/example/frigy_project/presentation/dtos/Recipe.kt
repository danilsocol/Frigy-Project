package com.example.frigy_project.presentation.dtos

data class Recipe(
    override val name: String,
    val categoryRecipe: RecipeCategory,
    val productList : List<Product>
) : IFilterable
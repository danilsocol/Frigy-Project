package com.example.frigy_project.models

data class Recipe(
    override val id: Int,
    override val name: String,
    val categoryRecipe: Int,
    val productList : List<Product>
) : BaseModel(id,name)
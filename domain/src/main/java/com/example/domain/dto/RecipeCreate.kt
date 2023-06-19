package com.example.domain.dto

import com.example.domain.models.Product

data class RecipeCreate(
    val title: String,
    val description : String,
    val recipeCategory: Int,
    val productList :  List<ProductCreate>
)
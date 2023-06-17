package com.example.data.models

import com.example.domain.dto.RecipeRequest

data class RecipeRequestImpl(
    override val id: Int,
    override val title: String,
    override val description : String,
    override val recipeCategory: Int,
    override val productList : List<ProductRequestImpl>,
): RecipeRequest

/*
val recipeCategoryList  =  listOf(
    (RecipeCategory(1, R.drawable.recipe_category_main_course_64)),
    (RecipeCategory(2, R.drawable.recipe_category_soup_64)),
    (RecipeCategory(3,R.drawable.recipe_category_salad_64))
)*/

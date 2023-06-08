package com.example.data.models

data class RecipeRequest(
    val name: String,
    val description : String,
    val categoryRecipe: Int,
    val productList : List<ProductStorageRequestImpl>
)

/*
val recipeCategoryList  =  listOf(
    (RecipeCategory(1, R.drawable.recipe_category_main_course_64)),
    (RecipeCategory(2, R.drawable.recipe_category_soup_64)),
    (RecipeCategory(3,R.drawable.recipe_category_salad_64))
)*/

package com.example.frigy_project.models.ListСategories

import com.example.frigy_project.R
import com.example.frigy_project.dtos.RecipeCategory

object RecipeCategoryList {

    val recipeCategoryList  =  listOf(
        (RecipeCategory(1, R.drawable.recipe_category_main_course_64)),
        (RecipeCategory(2, R.drawable.recipe_category_soup_64)),
        (RecipeCategory(3,R.drawable.recipe_category_salad_64))
    )
}
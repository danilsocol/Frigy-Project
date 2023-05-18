package com.example.frigy_project.models.ListСategories

import com.example.frigy_project.R
import com.example.frigy_project.models.RecipeCategory

object RecipeCategoryList {//todo переделать в sealde класс
    val recipeCategoryList  =  listOf(
        (RecipeCategory(1, R.drawable.recipe_category_main_course_64)),
        (RecipeCategory(2, R.drawable.recipe_category_soup_64)),
        (RecipeCategory(3,R.drawable.recipe_category_salad_64))
    )
}
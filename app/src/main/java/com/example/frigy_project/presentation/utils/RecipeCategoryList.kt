package com.example.frigy_project.presentation.utils

import com.example.domain.models.RecipeCategory
import com.example.frigy_project.R

object RecipeCategoryList {

    val recipeCategoryList  =  listOf(
        R.drawable.recipe_category_main_course_64,
        R.drawable.recipe_category_soup_64,
        R.drawable.recipe_category_salad_64
    )

    fun getRecipeImgCategory(recipeCategory: RecipeCategory): Int{
        return when (recipeCategory.id) {
            1 -> R.drawable.recipe_category_salad_64
            2 -> R.drawable.recipe_category_main_course_64
            3 -> R.drawable.recipe_category_soup_64
            else -> 0
        }
    }
}

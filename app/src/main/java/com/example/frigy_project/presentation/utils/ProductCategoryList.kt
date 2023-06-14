package com.example.frigy_project.presentation.utils

import com.example.domain.models.ProductCategory
import com.example.frigy_project.R

object ProductCategoryList {

    private val productCategoryList  =  listOf(
        R.drawable.product_category_liquid_64,
        R.drawable.product_category_weighing_64,
        R.drawable.product_category_piece_64,
    )

    fun getProductImgCategory(productCategory: ProductCategory): Int{
        return when (productCategory.id) {
            1 -> R.drawable.product_category_liquid_64
            2 -> R.drawable.product_category_weighing_64
            3 -> R.drawable.product_category_piece_64
            else -> 0
        }
    }

}
package com.example.frigy_project.presentation.utils

import com.example.domain.models.ProductCategory
import com.example.frigy_project.R

object ProductCategoryList {



    fun getProductImgCategory(productCategory: ProductCategory): Int{
        return when (productCategory.id) {
            0 -> R.drawable.product_category_liquid_64
            1 -> R.drawable.product_category_weighing_64
            2 -> R.drawable.product_category_piece_64
            else -> 0
        }
    }

}
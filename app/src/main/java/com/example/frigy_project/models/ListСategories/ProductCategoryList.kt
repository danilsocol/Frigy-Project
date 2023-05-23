package com.example.frigy_project.models.ListСategories

import com.example.frigy_project.R
import com.example.frigy_project.dtos.ProductCategory

object ProductCategoryList {

    val productCategoryList  =  listOf(
        (ProductCategory(1,"Жидкость", R.drawable.product_category_liquid_64,"литр")),
        (ProductCategory(2,"Взвешиваемый", R.drawable.product_category_weighing_64,"кг")),
        (ProductCategory(3,"Поштучный", R.drawable.product_category_piece_64,"шт"))
    )
}


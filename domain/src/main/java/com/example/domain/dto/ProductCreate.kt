package com.example.domain.dto

import com.example.domain.models.Product
import com.example.domain.models.ProductCategory

data class ProductCreate(
    val title: String,
    val productCategoryInt: Int,
    val isImportant : Boolean,
    val count: Int,
    val maxCount: Int?,
){
    constructor(
        title: String,
        productCategory: ProductCategory,
        isImportant : Boolean,
        count: Int,
        maxCount: Int?
    ) : this(title, productCategory.id , isImportant, count, maxCount)
}
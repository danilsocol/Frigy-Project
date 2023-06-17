package com.example.domain.dto

import com.example.domain.models.ProductCategory

data class ProductToBuyCreate(
     val title: String,
     val productCategory: Int,
     val isImportant : Boolean,
     val count: Int,
     val maxCount: Int?,
     val isBuy: Boolean,
) {
    constructor(
        title: String,
        productCategory: ProductCategory,
        isImportant : Boolean,
        count: Int,
        maxCount: Int?,
        isBuy: Boolean,
    ) : this(title, productCategory.id , isImportant, count, maxCount,isBuy)
}
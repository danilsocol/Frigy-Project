package com.example.domain.dto

import com.example.domain.models.ProductCategory

data class ProductToBuyCreate(
    override val title: String,
    override val productCategory: Int,
    override val isImportant : Boolean,
    override val count: Int,
    override val maxCount: Int?,
    override val isBuy: Boolean,
) : ProductToBuyRequest {
    constructor(
        title: String,
        productCategory: ProductCategory,
        isImportant : Boolean,
        count: Int,
        maxCount: Int?,
        isBuy: Boolean,
    ) : this(title, productCategory.id , isImportant, count, maxCount,isBuy)
}
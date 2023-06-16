package com.example.domain.dto

import com.example.domain.models.Product
import com.example.domain.models.ProductCategory

data class ProductCreate(
    override val title: String,
    override val productCategoryInt: Int,
    override val isImportant : Boolean,
    override val count: Int,
    override val maxCount: Int?,
) : ProductRequest{
    constructor(
        title: String,
        productCategory: ProductCategory,
        isImportant : Boolean,
        count: Int,
        maxCount: Int?
    ) : this(title, productCategory.id , isImportant, count, maxCount)
}
package com.example.data.models

import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest
import com.example.domain.models.Product

data class ProductRequestImpl (
    override val id: Int,
    override var title: String,
    override var productCategory: Int,
    override var isImportant : Boolean,
    override var count: Int,
    override var maxCount: Int?,
   ) : ProductRequest
{
    constructor(product : ProductCreate) : this(Product.getNewId(),product.title,product.productCategory,product.isImportant,product.count,product.maxCount)
}
package com.example.data.models

import com.example.domain.dto.ProductRequest
import com.example.domain.models.Product

data class ProductRequestImpl (
    override var title: String,
    override var productCategoryInt: Int,
    override var isImportant : Boolean,
    override var count: Int,
    override var maxCount: Int?,
   ) : ProductRequest

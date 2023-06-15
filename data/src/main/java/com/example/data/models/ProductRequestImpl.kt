package com.example.data.models

import com.example.domain.dto.ProductRequest

data class ProductRequestImpl (
    override val title: String,
    override val productCategory: Int,
    override val isImportant : Boolean,
    override val count: Int,
    override val maxCount: Int?,
   ) : ProductRequest
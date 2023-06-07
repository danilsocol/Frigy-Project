package com.example.data.models

import com.example.domain.dto.ProductStorageRequest

data class ProductStorageRequestImpl (
    override val title: String,
    override val productCategory: Int,
    override val isImportant : Boolean,
    override val countStorage: Int,
    override val maxCountStorage: Int?,
   ) : ProductStorageRequest
package com.example.data.models

import com.example.domain.dto.ProductToBuyRequest

data class ProductToBuyRequestImpl(
    override val title: String,
    override val productCategory: Int,
    override val isImportant: Boolean,
    override val count: Int,
    override val maxCount: Int?,
    override val isBuy: Boolean
) : ProductToBuyRequest
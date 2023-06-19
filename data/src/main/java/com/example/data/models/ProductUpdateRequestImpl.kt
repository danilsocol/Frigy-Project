package com.example.data.models

import com.example.domain.dto.ProductUpdateRequest

class ProductUpdateRequestImpl(
    override val id: Int,
    override val count: Int,
    override val maxCount: Int
) : ProductUpdateRequest {
}
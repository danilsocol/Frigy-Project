package com.example.data.models

import com.example.domain.dto.ProductToBuyUpdateRequest

class ProductToBuyUpdateRequestImpl(override val id: Int, override val isBuy: Boolean
): ProductToBuyUpdateRequest
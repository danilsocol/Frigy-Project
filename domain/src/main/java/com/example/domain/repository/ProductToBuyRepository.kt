package com.example.domain.repository

import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductToBuyCreate
import com.example.domain.dto.ProductToBuyRequest
import com.example.domain.models.Product

interface ProductToBuyRepository {

    suspend fun getAllStorageProducts(): List<Product>
    suspend fun createProduct(productToBuyCreate: ProductToBuyCreate)
}
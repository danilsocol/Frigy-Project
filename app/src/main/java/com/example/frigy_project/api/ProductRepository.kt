package com.example.frigy_project.api

import com.example.frigy_project.api.request.ProductRequest
import com.example.frigy_project.dtos.Product

class ProductRepository {

    private val retrofit = RetrofitBuilder.getClient()
    private val productApi = retrofit!!.create(ProductAPI::class.java)

    suspend fun getProductById(id: String): Product {
        return productApi.getProductById(id)
    }

    suspend fun getAllProducts(): List<Product> {
        return productApi.getAllProducts()
    }

    suspend fun createProduct(productRequest: ProductRequest): Product {
        return productApi.createProduct(productRequest)
    }
}
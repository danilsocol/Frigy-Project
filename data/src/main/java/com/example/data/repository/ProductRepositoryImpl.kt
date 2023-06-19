package com.example.data.repository

import com.example.data.models.ProductRequestImpl
import com.example.data.networks.ProductAPI
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest
import com.example.domain.models.Product
import com.example.domain.repository.ProductRepository
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(private val productApi : ProductAPI) : ProductRepository {

    override suspend fun getStorageProductById(id: Int): Product {
        val product = productApi.getProductById(id)
        return Product.getProduct(product)
    }
    override suspend fun getAllStorageProducts(): List<Product> {
        return Product.getAllProductStorage( productApi.getAllProducts())
    }
    override suspend fun createProduct(productCreate: ProductCreate) {
        val productRequest = ProductRequestImpl(Product.getNewId(),productCreate.title,productCreate.productCategory,productCreate.isImportant
            ,productCreate.count,productCreate.maxCount)
        productApi.createProduct(productRequest)
    }

    override suspend fun updateProduct(productRequest: ProductRequest) {
        val mapProduct = ProductRequestImpl(productRequest.id,productRequest.title,productRequest.productCategory,productRequest.isImportant
            ,productRequest.count,productRequest.maxCount)
        productApi.updateProduct(mapProduct)
    }
}
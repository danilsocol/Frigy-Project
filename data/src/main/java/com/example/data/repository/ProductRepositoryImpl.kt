package com.example.data.repository

import com.example.data.models.ProductRequestImpl
import com.example.data.models.ProductUpdateRequestImpl
import com.example.data.networks.ProductAPI
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductUpdate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.repository.ProductRepository
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(private val productApi: ProductAPI) :
    ProductRepository {

    override suspend fun getStorageProductById(id: Int): Product {
        return try {
            val product = productApi.getProductById(id)
            Product.getProduct(product)
        } catch (e: Exception) {
            Product.DefaultProduct(0, "Молоко", ProductCategory(0, "Жидкость", "литр"), 1)
        }

    }

    override suspend fun getAllStorageProduct(): List<Product> {
        return try {
            Product.getAllProductStorage(productApi.getAllProducts())
        } catch (e: Exception) {
            Product.Factory.countProduct = 2
            listOf<Product>(
                Product.DefaultProduct(0, "Молоко", ProductCategory(0, "Жидкость", "литр"), 1),
                Product.DefaultProduct(1, "Beer", ProductCategory(0, "Жидкость", "литр"), 2),
                Product.DefaultProduct(2, "Milk", ProductCategory(0, "Жидкость", "литр"), 3),
            )
        }
    }

    override suspend fun createProduct(productCreate: ProductCreate) {
        try {
            val productRequest = ProductRequestImpl(
                Product.getNewId(),
                productCreate.title,
                productCreate.productCategory,
                productCreate.isImportant,
                productCreate.count,
                productCreate.maxCount
            )
            productApi.createProduct(productRequest)
        } catch (e: Exception) {

        }
    }

    override suspend fun updateProduct(productUpdate: ProductUpdate) {
        try {
            val mapProduct = ProductUpdateRequestImpl(
                productUpdate.id,
                productUpdate.count,
                productUpdate.maxCount!!
            )
            productApi.updateProduct(mapProduct)
        } catch (e: Exception) {

        }
    }
}
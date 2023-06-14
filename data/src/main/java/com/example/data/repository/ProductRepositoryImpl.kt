package com.example.data.repository

import com.example.data.models.ProductStorageRequestImpl
import com.example.data.models.ProductToBuyRequestImpl
import com.example.data.networks.ProductAPI
import com.example.data.retrofit.RetrofitBuilder
import com.example.domain.dto.ProductCreate
import com.example.domain.models.Product
import com.example.domain.repository.ProductRepository
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(private val productApi : ProductAPI) : ProductRepository { // todo выделить отдельный класс, а репозиторий оставить общим (а может и нет)

    override suspend fun getStorageProductById(id: String): Product {
        val product = productApi.getProductById(id)
        return Product.getProductStorage(product)
    }

    override suspend fun getAllStorageProducts(): List<Product> {
        return Product.getAllProductStorage( productApi.getAllProducts())
    }

    override suspend fun createProduct(product: ProductCreate): Product {
        val mapProduct = ProductStorageRequestImpl(product.title,product.productCategory,product.isImportant,product.countStorage,product.maxCountStorage) //todo правильно ли мапить из 1 потом обратно?
        val result = productApi.createProduct(mapProduct)
        return Product.getProductStorage(result)
    }
}
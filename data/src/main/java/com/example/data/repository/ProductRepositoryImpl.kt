package com.example.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.data.models.ProductRequestImpl
import com.example.data.models.ProductUpdateRequestImpl
import com.example.data.networks.ProductAPI
import com.example.domain.dto.ProductCreate
import com.example.domain.dto.ProductRequest
import com.example.domain.dto.ProductUpdate
import com.example.domain.models.Product
import com.example.domain.models.ProductCategory
import com.example.domain.repository.ProductRepository
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(private val productApi : ProductAPI) : ProductRepository {

    override suspend fun getStorageProductById(id: Int): Product {
        try {
            val product = productApi.getProductById(id)
            return Product.getProduct(product)
        }
        catch (e : Exception){ // todo в будушем тут будет localstorage
            return  Product.DefaultProduct(0,"Молоко", ProductCategory(0,"Жидкость", "литр"),  1)
        }

    }
    override suspend fun getAllStorageProduct(): List<Product> {
        try{
        return Product.getAllProductStorage( productApi.getAllProducts())
        }
        catch (e : Exception){ // todo в будушем тут будет localstorage
            return  listOf<Product>(
                Product.DefaultProduct(0,"Молоко", ProductCategory(0,"Жидкость", "литр"),  1),
                Product.DefaultProduct(1, "Beer", ProductCategory(0,"Жидкость", "литр"),  2),
                Product.DefaultProduct(2, "Milk", ProductCategory(0,"Жидкость", "литр"),  3),
            )
        }
    }
    override suspend fun createProduct(productCreate: ProductCreate) {
        try{
            val productRequest = ProductRequestImpl(Product.getNewId(),productCreate.title,productCreate.productCategory,productCreate.isImportant
                ,productCreate.count,productCreate.maxCount)
            productApi.createProduct(productRequest)
        }
        catch (e : Exception){ // todo в будушем тут будет localstorage

        }
    }

    override suspend fun updateProduct(productUpdate: ProductUpdate) {
        try{
            val mapProduct = ProductUpdateRequestImpl(productUpdate.id,productUpdate.count,productUpdate.maxCount!!)
            productApi.updateProduct(mapProduct)
        }
        catch (e : Exception){ // todo в будушем тут будет localstorage

        }
    }
}
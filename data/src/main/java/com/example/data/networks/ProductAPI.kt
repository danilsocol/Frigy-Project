package com.example.data.networks

import com.example.data.models.ProductStorageRequestImpl
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductAPI {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id : String) : ProductStorageRequestImpl //todo возможно библотека не будет работать

    @GET("products")
    suspend fun getAllProducts() : List<ProductStorageRequestImpl>

    @POST("products")
    suspend fun createProduct(@Body product: ProductStorageRequestImpl) : ProductStorageRequestImpl
}
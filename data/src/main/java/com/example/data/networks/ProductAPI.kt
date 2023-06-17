package com.example.data.networks

import com.example.data.models.ProductRequestImpl
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductAPI {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id : Int) : ProductRequestImpl //todo возможно библотека не будет работать

    @GET("products")
    suspend fun getAllProducts() : List<ProductRequestImpl>

    @POST("products")
    suspend fun createProduct(@Body product: ProductRequestImpl) : ProductRequestImpl
}
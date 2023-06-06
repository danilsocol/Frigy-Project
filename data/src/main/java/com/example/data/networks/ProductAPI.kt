package com.example.data.networks

import com.example.data.models.ProductRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductAPI {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id : String) : ProductRequest //todo возможно библотека не будет работать

    @GET("products")
    suspend fun getAllProducts() : List<ProductRequest>

    @POST("products")
    suspend fun createProduct(@Body product: ProductRequest) : ProductRequest
}
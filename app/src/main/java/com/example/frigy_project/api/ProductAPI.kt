package com.example.frigy_project.api

import com.example.frigy_project.api.request.ProductRequest
import com.example.frigy_project.models.Product
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductAPI {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id : String) : Product //todo возможно библотека не будет работать

    @GET("products")
    suspend fun getAllProducts() : List<Product>

    @POST("products")
    suspend fun createProduct(@Body productRequest: ProductRequest) : Product
}
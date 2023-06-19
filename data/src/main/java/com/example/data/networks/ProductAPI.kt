package com.example.data.networks

import com.example.data.models.ProductRequestImpl
import com.example.domain.dto.ProductCreate
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
interface ProductAPI {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id : Int) : ProductRequestImpl //todo возможно библотека не будет работать

    @GET("/api/Product/all")
    suspend fun getAllProducts() : List<ProductRequestImpl>

    @POST("products")
    suspend fun createProduct(@Body product: ProductRequestImpl)
    @PUT("products")
    suspend fun updateProduct(@Body product: ProductRequestImpl)
}
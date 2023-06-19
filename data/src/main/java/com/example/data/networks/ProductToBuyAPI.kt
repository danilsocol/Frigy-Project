package com.example.data.networks

import com.example.data.models.ProductRequestImpl
import com.example.data.models.ProductToBuyRequestImpl
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductToBuyAPI {

    @GET("/api/ProductToBuy/all")
    suspend fun getAllProducts() : List<ProductToBuyRequestImpl>

    @POST("/api/ProductToBuy/")
    suspend fun createProduct(@Body product: ProductToBuyRequestImpl) : ProductToBuyRequestImpl
}
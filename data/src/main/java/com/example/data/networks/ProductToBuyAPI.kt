package com.example.data.networks

import com.example.data.models.ProductRequestImpl
import com.example.data.models.ProductToBuyRequestImpl
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ProductToBuyAPI {

    @GET("/api/ProductToBuy/all")
    suspend fun getAllProducts() : List<ProductToBuyRequestImpl>

    @POST("/api/ProductToBuy/")
    suspend fun createProduct(@Body product: ProductToBuyRequestImpl) : ProductToBuyRequestImpl

    @DELETE("/api/ProductToBuy/")
    suspend fun deleteCheckProducts(@Body list : List<Int>)

    @PUT("/api/ProductToBuy/")
    suspend fun updateProduct(@Body product: ProductRequestImpl)
}
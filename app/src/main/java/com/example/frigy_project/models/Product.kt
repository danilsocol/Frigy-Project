package com.example.frigy_project.models

open class Product (
    open val id: Int,
    open val name: String,
    open val categoryProduct: Int,
    open val count: Double)
{

    data class ImportantProduct(
        override val id: Int,
        override val name: String,
        override val categoryProduct: Int,
        override val count: Double,
        val maxCount: Double
    ) : Product(id,name,categoryProduct,count)

    data class ProductToBuy(
        override val id: Int,
        override val name: String,
        override val categoryProduct: Int,
        override val count: Double,
        val isBuy : Boolean = false
    ) : Product(id,name,categoryProduct,count)

}



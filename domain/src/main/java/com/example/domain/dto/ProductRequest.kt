package com.example.domain.dto

interface ProductRequest{
    val title: String
    val productCategoryInt: Int
    val isImportant : Boolean
    val count: Int
    val maxCount: Int?
}
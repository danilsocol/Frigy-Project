package com.example.domain.dto

interface ProductRequest{
    val title: String
    val productCategory: Int
    val isImportant : Boolean
    val count: Int
    val maxCount: Int?
}
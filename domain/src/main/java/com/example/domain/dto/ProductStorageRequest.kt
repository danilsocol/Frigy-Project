package com.example.domain.dto

interface ProductStorageRequest{
    val title: String
    val productCategory: Int
    val isImportant : Boolean
    val countStorage: Int
    val maxCountStorage: Int?
}
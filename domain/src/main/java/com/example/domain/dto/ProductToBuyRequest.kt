package com.example.domain.dto

interface ProductToBuyRequest {
    val title: String
    val productCategory: Int
    val isImportant : Boolean
    val countToBuy: Int
    val maxCountStorage: Int?
    val isBuy: Boolean
}
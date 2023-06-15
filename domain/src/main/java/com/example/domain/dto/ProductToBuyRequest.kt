package com.example.domain.dto

interface ProductToBuyRequest {
    val title: String
    val productCategory: Int
    val isImportant : Boolean
    val count: Int
    val maxCount: Int?
    val isBuy: Boolean
}
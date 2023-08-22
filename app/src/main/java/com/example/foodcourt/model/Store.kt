package com.example.foodcourt.model

import java.io.Serializable

data class Store(
    val storeId: Int,
    val storeName: String,
    val storeDescription: String,
    val storeLogo: String
) : Serializable

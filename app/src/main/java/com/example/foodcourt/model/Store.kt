package com.example.foodcourt.model

import java.io.Serializable

data class Store(
    val StoreID: Int,
    val StoreName: String,
    val StoreDescription: String,
    val StoreLogo: String
) : Serializable

package com.example.foodcourt.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Store(
    @SerializedName("StoreID") val storeId: Int,
    @SerializedName("StoreName") val storeName: String,
    @SerializedName("StoreDescription") val storeDescription: String,
    @SerializedName("StoreLogo") val storeLogo: String
) : Serializable

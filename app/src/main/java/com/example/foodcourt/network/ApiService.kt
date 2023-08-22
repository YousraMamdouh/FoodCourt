package com.example.foodcourt.network

import com.example.foodcourt.model.StoresList
import retrofit2.http.GET

interface ApiService{
    @GET("stores.json")
    suspend fun getStores():StoresList
}
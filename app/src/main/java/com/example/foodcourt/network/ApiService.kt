package com.example.foodcourt.network

import com.example.foodcourt.model.Store
import retrofit2.http.GET

interface ApiService{
    @GET("stores.json")
    suspend fun getStores():List<Store>
}
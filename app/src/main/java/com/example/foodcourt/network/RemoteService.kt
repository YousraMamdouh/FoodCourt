package com.example.foodcourt.network

import com.example.foodcourt.model.StoresList

interface RemoteService {
    suspend fun getAllStores():StoresList
}
package com.example.foodcourt.network

import com.example.foodcourt.model.Store

interface RemoteService {
    suspend fun getAllStores():List<Store>
}
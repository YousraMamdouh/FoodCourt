package com.example.foodcourt.network

import com.example.foodcourt.model.Store
import com.example.foodcourt.model.StoresList

interface RemoteService {
    suspend fun getAllStores():List<Store>
}
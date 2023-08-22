package com.example.foodcourt.model

interface RepoInterface {
    suspend fun getAllStores(): List<Store>

}
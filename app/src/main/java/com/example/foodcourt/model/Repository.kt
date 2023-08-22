package com.example.foodcourt.model

import android.util.Log
import com.example.foodcourt.network.RemoteService

class Repository(var remoteSource:RemoteService):RepoInterface{



    companion object{
        private var instance:Repository?=null
        fun getInstance(
            remoteSource: RemoteService
        ):Repository{
            return instance?: synchronized(this){
                val temp=Repository(
                    remoteSource
                )
                instance=temp
                temp
            }
        }
    }

    override suspend fun getAllStores(): List<Store> {
        //Log.d("Yousra", "Look: ${remoteSource.getAllStores()[0].storeName}")
        return remoteSource.getAllStores()
    }
}
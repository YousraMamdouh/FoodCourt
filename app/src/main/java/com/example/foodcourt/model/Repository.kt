package com.example.foodcourt.model

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

    override suspend fun getAllStores(): StoresList {
        return remoteSource.getAllStores()
    }
}
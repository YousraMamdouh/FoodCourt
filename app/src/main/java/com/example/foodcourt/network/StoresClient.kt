import com.example.foodcourt.model.StoresList
import com.example.foodcourt.network.ApiService
import com.example.foodcourt.network.RemoteService
import com.example.foodcourt.network.RetrofitHelper

class StoresClient: RemoteService {

    val apiService: ApiService by lazy {
        RetrofitHelper.retrofitInstance.create(ApiService::class.java)
    }



    companion object{
        private var instance: StoresClient?=null
        fun getInstance(): StoresClient {
            return instance?: synchronized(this)
            {
                val temp= StoresClient()
                instance=temp
                temp
            }
        }
    }
    override suspend fun getAllStores(): StoresList {
        val response =  apiService.getStores()
        return response
    }

}
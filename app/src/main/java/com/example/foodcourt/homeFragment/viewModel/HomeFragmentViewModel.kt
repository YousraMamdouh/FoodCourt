package com.example.foodcourt.homeFragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodcourt.model.RepoInterface
import com.example.foodcourt.model.Store
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragmentViewModel(private val _repo:RepoInterface): ViewModel() {
    private var _stores: MutableLiveData<List<Store>> = MutableLiveData<List<Store>>()
    val products: LiveData<List<Store>> = _stores
    init {
        getProductsFromAPI()
    }


    private fun getProductsFromAPI()
    {
        viewModelScope.launch(Dispatchers.IO) {
            _stores.postValue(_repo.getAllStores())
        }
    }
}
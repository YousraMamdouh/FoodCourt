package com.example.foodcourt.homeFragment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodcourt.model.RepoInterface


class HomeFragmentViewModelFactory(private val _repo: RepoInterface): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)){
            HomeFragmentViewModel(_repo) as T
        }else{
            throw IllegalArgumentException("View class not found")
        }

    }
}
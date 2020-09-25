package com.pibusa.firstmvvmapp.ui.login.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pibusa.firstmvvmapp.data.repositry.HomeRepository
import com.pibusa.firstmvvmapp.data.repositry.UserRepositry

class HomeViewModelFactory(private val repository: HomeRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}
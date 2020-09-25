package com.pibusa.firstmvvmapp.ui.login.home

import androidx.lifecycle.ViewModel
import com.pibusa.firstmvvmapp.data.repositry.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel(private val repositry: HomeRepository) : ViewModel() {
    suspend fun getWeatherList(city: String, empId: String) = withContext(Dispatchers.IO)
    {
        repositry.getWeatherDetails(city, empId)
    }

}
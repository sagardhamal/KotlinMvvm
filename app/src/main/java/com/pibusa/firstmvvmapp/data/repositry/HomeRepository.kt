package com.pibusa.firstmvvmapp.data.repositry

import com.pibusa.firstmvvmapp.data.network.MyApi
import com.pibusa.firstmvvmapp.data.network.SafeApiRequest
import com.pibusa.firstmvvmapp.data.network.responses.WeCurrentWeather

class HomeRepository(private val api:MyApi): SafeApiRequest() {
     suspend fun getWeatherDetails(city: String, empId: String): WeCurrentWeather {
        return apiRequest {
            api.getCurrentWeather(city, empId,"")
        }
    }
}
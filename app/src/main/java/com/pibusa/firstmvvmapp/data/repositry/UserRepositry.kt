package com.pibusa.firstmvvmapp.data.repositry

import com.pibusa.firstmvvmapp.data.network.MyApi
import com.pibusa.firstmvvmapp.data.network.SafeApiRequest
import net.simplifiedcoding.mvvmsampleapp.data.network.responses.AuthResponse

class UserRepositry(private val api: MyApi) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }
}
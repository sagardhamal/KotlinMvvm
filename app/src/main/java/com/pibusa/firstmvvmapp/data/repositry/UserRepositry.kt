package com.pibusa.firstmvvmapp.data.repositry

import com.pibusa.firstmvvmapp.data.db.entites.AppDatabase
import com.pibusa.firstmvvmapp.data.db.entites.UserDb
import com.pibusa.firstmvvmapp.data.network.MyApi
import com.pibusa.firstmvvmapp.data.network.SafeApiRequest
import com.pibusa.firstmvvmapp.data.network.responses.AuthResponse


class UserRepositry(
    private val api: MyApi,
    private val database: AppDatabase
) : SafeApiRequest() {


    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun saveUser(user: UserDb) = database.getUserDao().userInsert(user)

    fun getUser() = database.getUserDao().getUser()


}
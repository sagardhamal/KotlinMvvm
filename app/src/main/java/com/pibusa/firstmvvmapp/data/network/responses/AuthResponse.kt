package com.pibusa.firstmvvmapp.data.network.responses

import com.pibusa.firstmvvmapp.data.db.entites.UserDb


data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: UserDb?
)
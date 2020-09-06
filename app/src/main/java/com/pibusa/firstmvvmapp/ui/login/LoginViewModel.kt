package com.pibusa.firstmvvmapp.ui.login

import androidx.lifecycle.ViewModel
import com.pibusa.firstmvvmapp.data.db.entites.UserDb
import com.pibusa.firstmvvmapp.data.repositry.UserRepositry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LoginViewModel(private val repositry: UserRepositry) : ViewModel() {
    suspend fun userLogin(
        email: String,
        password: String
    ) = withContext(Dispatchers.IO) { repositry.userLogin(email, password) }

    suspend fun saveLoginUser(user: UserDb) = repositry.saveUser(user)

    fun getLoginUserDetails() = repositry.getUser()
}


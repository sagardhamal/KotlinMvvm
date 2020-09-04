package com.pibusa.firstmvvmapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pibusa.firstmvvmapp.data.data.UserRepositry
@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory (
    private val repository: UserRepositry
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }
}
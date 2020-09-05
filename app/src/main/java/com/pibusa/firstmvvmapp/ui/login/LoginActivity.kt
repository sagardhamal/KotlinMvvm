package com.pibusa.firstmvvmapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.pibusa.firstmvvmapp.R
import com.pibusa.firstmvvmapp.databinding.ActivityLoginBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import com.pibusa.firstmvvmapp.utils.snackbar
import java.lang.Exception
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import org.kodein.di.Kodein

class LoginActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)


        binding.buttonSignIn.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val email = binding.editTextEmail.text.toString().trim()
        val password = binding.editTextPassword.text.toString().trim()

        lifecycleScope.launch {
            try {
                val authResponse = viewModel.userLogin(email, password)
                if (authResponse.message != null) {
                    binding.rootLayout.snackbar(authResponse.message!!)
                    // viewModel.saveLoggedInUser(authResponse.user)
                }/* else {
                    binding.rootLayout.snackbar(authResponse.message!!)
                }*/
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}


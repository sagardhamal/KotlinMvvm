package com.pibusa.firstmvvmapp.ui.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.pibusa.firstmvvmapp.R
import com.pibusa.firstmvvmapp.databinding.ActivityLoginBinding
import com.pibusa.firstmvvmapp.utils.snackbar
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), KodeinAware {
    private val TAG = "LoginActivity"
    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()
    private lateinit var binding: ActivityLoginBinding
    private var viewModel: LoginViewModel? = null

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
                val authResponse = viewModel?.userLogin(email, password)
                if (authResponse?.message != null) {
                    Log.e(TAG, "loginUser: ${authResponse.message}")
                    //binding.rootLayout.snackbar(authResponse.message)
                    // viewModel.saveLoggedInUser(authResponse.user)
                } else {
                    //binding.rootLayout.snackbar(authResponse.message!!)
                    Log.e(TAG, "loginUser: ${authResponse?.message}")
                }
            } catch (e: Exception) {
                Log.e(TAG, "loginUser: ", e)
            }
        }
    }
}


package com.pibusa.firstmvvmapp.ui.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.pibusa.firstmvvmapp.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), KodeinAware {
    private val TAG = "LoginActivity"
    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()

    private var viewModel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)

        button_sign_in.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val email = edit_text_email.text.toString().trim()
        val password = edit_text_password.text.toString().trim()

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


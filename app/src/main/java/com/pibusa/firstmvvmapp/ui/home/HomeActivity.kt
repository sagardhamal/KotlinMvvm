package com.pibusa.firstmvvmapp.ui.login.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.pibusa.firstmvvmapp.R
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HomeActivity : AppCompatActivity(), KodeinAware {
    val TAG = "HomeActivity"

    companion object {
        private val appId = "4017c85936fc42617cff4bc115dd2214"
        val cityList: ArrayList<String> = arrayListOf(
            "Mumbai",
            "Delhi",
            "Kolkata",
            "Chennai",
            "Bangalore",
            "Hyderabad",
            "Ahmedabad",
            "Pune",
            "Surat",
            "Jaipur"
        )
    }

    override val kodein by kodein()
    private var homeViewModel: HomeViewModel? = null

    private val factory: HomeViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeViewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        getWeatherList()
    }

    private fun getWeatherList() {
        lifecycleScope.launch {
            val response = homeViewModel?.getWeatherList("Mumbai", appId)
            Log.d(TAG, response.toString())
            /*  if(response?.message!=null){

              }*/
        }
    }
}
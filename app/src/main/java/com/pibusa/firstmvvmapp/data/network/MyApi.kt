package com.pibusa.firstmvvmapp.data.network

import com.pibusa.firstmvvmapp.data.network.responses.AuthResponse
import com.pibusa.firstmvvmapp.data.network.responses.WeCurrentWeather
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {
    @FormUrlEncoded
    @POST("login")
    fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>

    @GET("weather/")
    fun getCurrentWeather(
        @Query("q") city: String?,
        @Query("appid") employeeId: String?,
        @Query("units") units: String? = "metric"
    ): Response<WeCurrentWeather>

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): MyApi {
            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("http://api.openweathermap.org/data/2.5/")//https://api.simplifiedcoding.in/course-apis/mvvm/
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}


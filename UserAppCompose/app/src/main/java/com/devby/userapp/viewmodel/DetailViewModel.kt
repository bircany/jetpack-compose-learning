package com.devby.userapp.viewmodel

import androidx.lifecycle.ViewModel
import com.devby.userapp.model.User
import com.devby.userapp.service.UserAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailViewModel : ViewModel() {
    private val BASE_URL = "https://raw.githubusercontent.com/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)

    suspend fun getSingleUser(id : Int) : User {
        val user = retrofit.getSingleUser()[id]
        return user
    }
}
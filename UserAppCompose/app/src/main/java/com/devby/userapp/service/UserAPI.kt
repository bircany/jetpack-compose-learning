package com.devby.userapp.service

import com.devby.userapp.model.User
import retrofit2.http.GET

interface UserAPI {

    @GET("atilsamancioglu/UsersJSONPlaceHolder/refs/heads/main/users.json")
    suspend fun getData(): List<User>

    @GET("atilsamancioglu/UsersJSONPlaceHolder/refs/heads/main/users.json")
    suspend fun getSingleUser(): List<User>

}
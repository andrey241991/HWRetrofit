package com.example.home_pc.hw_retrofit.network

import androidx.lifecycle.LiveData
import com.example.home_pc.hw_retrofit.model.StudentData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/users/{username}")
    fun getUserByName(@Path("username") username: String): Call<StudentData>


}
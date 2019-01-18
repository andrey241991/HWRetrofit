package com.example.home_pc.hw_retrofit.repository

import com.example.home_pc.hw_retrofit.network.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getClient(): GitHubService {
        return retrofit.create(GitHubService::class.java)
    }

}
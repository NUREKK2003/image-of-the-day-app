package com.example.imageofthedayapp.repository

import com.example.imageofthedayapp.api.RetrofitInstance
import com.example.imageofthedayapp.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}
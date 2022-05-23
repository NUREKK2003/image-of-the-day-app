package com.example.imageofthedayapp.api

import com.example.imageofthedayapp.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("planetary/apod?api_key=DEMO_KEY")
    suspend fun getPost(): Response<Post>
}
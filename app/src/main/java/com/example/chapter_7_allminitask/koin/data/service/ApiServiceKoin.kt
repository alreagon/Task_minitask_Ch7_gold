package com.example.chapter_7_allminitask.koin.data.service

import com.example.chapter_7_allminitask.koin.data.model.GetAllPostsResponseItemKoin
import retrofit2.http.GET

interface ApiServiceKoin {
    @GET("posts")
    suspend fun getAllPosts(): List<GetAllPostsResponseItemKoin>
}
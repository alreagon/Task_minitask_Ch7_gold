package com.example.chapter_7_allminitask.koin.data.service

class ApiHelperKoin(private val apiServiceKoin: ApiServiceKoin) {
    suspend fun getAllPosts() = apiServiceKoin.getAllPosts()
}